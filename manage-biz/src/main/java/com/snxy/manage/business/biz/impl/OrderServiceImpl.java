package com.snxy.manage.business.biz.impl;

import com.github.pagehelper.PageHelper;
import com.snxy.common.exception.BizException;
import com.snxy.common.response.ResultData;
import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.biz.feign.FileImageService;
import com.snxy.manage.business.dao.mapper.*;

import com.snxy.manage.business.dao.mapper.EntryFeeMapper;
import com.snxy.manage.business.domain.*;
import com.snxy.manage.business.service.OrderService;
import com.snxy.manage.business.service.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Resource
    private DeliveryOrderMapper deliveryOrderMapper;
    @Resource
    private GuaranteeDepositMapper guaranteeDepositMapper;
    @Resource
    private EntryFeeMapper entryFeeMapper;
    @Resource
    private FileImageService FileImageService;
    @Resource
    private VegetableCertificateMapper vegetableCertificateMapper;
    @Resource
    private VegetableImageMapper vegetableImageMapper;
    @Resource
    private QualitySheetMapper qualitySheetMapper;
    @Resource
    private VegetableDeliveryRelationMapper  vegetableDeliveryRelationMapper;
    @Override
    public OrderNoAndNameVO generateOrderNo(String operatorName) {
        Integer lastQualityNo = (Integer) redisTemplate.opsForValue().get("qualityNo");
        String sixNumber;
        if (lastQualityNo == null || lastQualityNo.equals("")) {
            redisTemplate.opsForValue().set("qualityNo", 1);
            sixNumber= String.format("%06d", 1);
        } else {
            redisTemplate.opsForValue().set("qualityNo", lastQualityNo + 1);
            sixNumber= String.format("%06d",lastQualityNo + 1 );
        }
        Date now=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmss");
        //生成订单号
        StringBuffer sb=new StringBuffer();
        sb.append("PTJM");
        sb.append(sf.format(now));
        sb.append(sixNumber);
        //查询出操作人员姓名
        OrderNoAndNameVO orderNoAndNameVO =OrderNoAndNameVO
                .builder()
                .orderNo(sb.toString())
                .operateName(operatorName)
                .build();
        return orderNoAndNameVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createOrder(ThroughTheDoorOrderVo throughTheDoorOrderVo) {
        long operateId=1;
        Date now =new Date();
        //订单信息入库
        DeliveryOrder deliveryOrder= DeliveryOrder.builder()
                .createRoleType(1)//进出门人员创建的
                .creatorId(operateId)//操作人员
                .creator(throughTheDoorOrderVo.getOperaterName())//操作人员姓名
                .driverName(throughTheDoorOrderVo.getPayName())//缴费人员姓名
                .driverMobile(throughTheDoorOrderVo.getPayPhone())//缴费人员手机号
                .loadStatus(Integer.parseInt(throughTheDoorOrderVo.getLoad()))//装货状态
                .gmtCreate(now)//当前时间
                .build();
        deliveryOrderMapper.insert(deliveryOrder);
        //查出单号id
        Long orderId=deliveryOrderMapper.selectByOrderNo(throughTheDoorOrderVo.getOrderNo());


        //进门费入库
        EntryFee entryFee=EntryFee.builder()
                .deliveryOrderId(orderId)
                .gmtCreate(now)
                .estFee(new BigDecimal(throughTheDoorOrderVo.getTheDoorFee()))
                .status(0)
                .build();
        entryFeeMapper.insert(entryFee);
        //检测费入库(暂时不存)
        //押金入库
        GuaranteeDeposit guaranteeDeposit=GuaranteeDeposit.builder()
                .deliveryOrderId(orderId)//订单id
                .gmtCreate(now)//创建时间
                .status(0)//待缴费
                .guaranteeDeposit(new BigDecimal(throughTheDoorOrderVo.getTheDeposit())) //押金
                .build();
        guaranteeDepositMapper.insert(guaranteeDeposit);
        //质量检测单，产地证明上传
        upload(orderId,throughTheDoorOrderVo.getCertificates());
        //货品照片上传
        insertVegetableImage(orderId,throughTheDoorOrderVo.getGoodImages());
        return "创建发货订单成功";
    }

    @Override
    public OrderVO getOrderInfoByOrderId(String orderId) {
        //查出货运单信息
        Long deliveryOrderID=Long.parseLong(orderId);
        DeliveryOrder  deliveryOrder=deliveryOrderMapper.selectByPrimaryKey(deliveryOrderID);

        //押金
        EntryFee entryFee=entryFeeMapper.selectEntryFeeByOrderId(deliveryOrderID);
        //进门费
        GuaranteeDeposit guaranteeDeposit=guaranteeDepositMapper.selectGuaranteeByOrderId(deliveryOrderID);
        //货品照片
        List<VegetableImage> vegetableImage=vegetableImageMapper.selectVegetableImageByOrderId(deliveryOrderID);
        //产地证明，检测证明
       List< VegetableCertificate> vegetableCertificate =vegetableCertificateMapper.selectVOByOrderId(deliveryOrderID);

        List<ValicatePictureVO> certificates=new ArrayList<>();
        for(VegetableCertificate vegetableCertificateone:vegetableCertificate){
            ValicatePictureVO valicateImageVO=new ValicatePictureVO();
            if(1==vegetableCertificateone.getCertificateType()){
                valicateImageVO.setCertificateType(1);
                //请求图片服务器，获取图片
                valicateImageVO.setFile(FileImageService.download(vegetableCertificateone.getUrl()).getData());
            }else{
                valicateImageVO.setCertificateType(2);
                valicateImageVO.setFile(FileImageService.download(vegetableCertificateone.getUrl()).getData());
            }
            certificates.add(valicateImageVO);
        }
        // 图片
        List<byte[]> goodImages=new ArrayList<>();
        for(VegetableImage vegetableImageOne:vegetableImage){
            goodImages.add(FileImageService.download(vegetableImageOne.getUrl()).getData());
        }
        //货品信息
        List<VegetableDeliveryRelation> vegetableDeliveryRelationList=vegetableDeliveryRelationMapper.selectByOrderId(deliveryOrderID);
         List<String> categoryNames=new ArrayList<>();
        vegetableDeliveryRelationList.forEach(vegetableDeliveryRelation->categoryNames.add(vegetableDeliveryRelation.getVegetableName()));
        //查询出检测证明的费用
        QualitySheet qualitySheet=qualitySheetMapper.selectByOrderId(deliveryOrderID);
        OrderVO orderVO= OrderVO.builder()
                .carType("")//先为空
                .category(categoryNames)
                .certificates(certificates)
                .detectCost(qualitySheet.getCheckFee())//检测费
                .driverName(deliveryOrder.getDriverName())
                .driverPhone(deliveryOrder.getDriverMobile())
                .goodImages(goodImages)//图片地址
                .load(deliveryOrder.getLoadStatus())
                .operaterName(deliveryOrder.getCreator())
                .orderNo(deliveryOrder.getOrderNo())
                .platNumber(deliveryOrder.getDriverPlateNumber())
                .remark("")//备注
                .theDeposit(guaranteeDeposit.getGuaranteeDeposit())//押金
                .theDoorFee(entryFee.getActualFee())//进门费
                .theTotalAmount("")//总费用
                .build();
        return orderVO;
    }
    //设置产地证明，检测证明无效
    @Transactional(rollbackFor = Exception.class)
    @Override
    public String settingProvesInvalid(SettingProvesInvalidVO settingProvesInvalidVO) {
        Date now =new Date();
        vegetableCertificateMapper.updateCertificate(Long.parseLong(settingProvesInvalidVO.getOrderId()),settingProvesInvalidVO.getStatus(),now);
        return "设置无效成功";
    }

    @Override
    public PageInfo<OrdeerSheetVO> getOrderSheetVOList(SystemUserVO systemUserVO, String status) {
        long userId=1;
        List<OrdeerSheetVO>orderSheetVOList=new ArrayList<>();
        PageHelper.startPage(1,10);
      deliveryOrderMapper.selectByOperateIdAndStatus(userId,status)
              .forEach(( deliveryOrder)->orderSheetVOList.add(
                      OrdeerSheetVO.builder()
                              .id(deliveryOrder.getId())//订单id
                              .creator(deliveryOrder.getCreator())//建单人
                              .driverMobile(deliveryOrder.getDriverMobile())//司机手机号
                              .driverName(deliveryOrder.getDriverName())//司机姓名
                              .driverPlateNumber(deliveryOrder.getDriverPlateNumber())//车牌号
                              .orderNo(deliveryOrder.getOrderNo())//订单号
                              .receiverCompany(deliveryOrder.getReceiverCompany())//收货人公司
                              .build()
              ));

        PageInfo<OrdeerSheetVO> pageInfo;
        pageInfo=new PageInfo<>();
        pageInfo.setData(orderSheetVOList);
        return pageInfo;
    }


    public VegetableCertificate uploadImg(MultipartFile file, Long deliveryOrderId, Integer certificateType){
        ResultData<String> upload = FileImageService.upload(file);
        if (!upload.isResult()) {
            throw new BizException(upload.getMsg());
        }
        String url = upload.getData();
        VegetableCertificate vegetableCertificate = VegetableCertificate.builder()
                .gmtCreate(new Date())
                .status(1)
                .uploadTime(new Date())
                .url(url)
                .certificateType(certificateType)
                .deliveryOrderId(deliveryOrderId)
                .build();
        return vegetableCertificate;
    }
    //存入数据库中
    @Transactional(rollbackFor = Exception.class)
    public void upload(Long deliveryOrderId, List<ValicateImageVO> certificates) {
        List<VegetableCertificate> vegetableCertificateList = new ArrayList<>();
        for (int i = 0; i < certificates.size(); i++) {
            Integer certificateType = certificates.get(i).getCertificateType();
            VegetableCertificate vegetableCertificate = uploadImg(certificates.get(i).getFile(),deliveryOrderId,certificateType);
            //如果是质检单
            if(certificateType == 2){
                vegetableCertificate.setXfdCertificate(0);
            }
            vegetableCertificateList.add(vegetableCertificate);
        }
        vegetableCertificateMapper.insertCertificateList(vegetableCertificateList);
    }
    // 货品照片入库
    @Transactional(rollbackFor = Exception.class)
    public void insertVegetableImage(Long orderId,List<MultipartFile>files){
        Date now =new Date();
       for(MultipartFile file:files){

          VegetableImage vegetableImage= VegetableImage.builder()
                   .deliveryOrderId(orderId)
                   .gmtCreate(now)
                   .uploadTime(now)
                   .url(FileImageService.upload(file).getData())
                   .type(1)//新建货运单增加的照片
                   .build();
           vegetableImageMapper.insert(vegetableImage);
       }

    }
}
