package com.snxy.manage.business.biz.impl;

import com.snxy.common.exception.BizException;
import com.snxy.common.response.ResultData;
import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.biz.feign.FileNumService;
import com.snxy.manage.business.dao.mapper.*;
import com.snxy.manage.business.domain.*;
import com.snxy.manage.business.service.OutFeeOrderImageService;
import com.snxy.manage.business.service.OutFeeOrderService;
import com.snxy.manage.business.service.vo.OutFeeOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OutFeeOrderServiceImpl implements OutFeeOrderService {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private VegetableMapper vegetableMapper;
    @Resource
    private VegetableTempMapper vegetableTempMapper;
    @Resource
    private OutFeeOrderMapper outFeeOrderMapper;
    @Resource
    private OutFeeOrderImageService outFeeOrderImageService;
    @Resource
    private OutFeeVegetableRelationMapper outFeeVegetableRelationMapper;
    @Resource
    private DrivewayDicMapper drivewayDicMapper;
    @Resource
    private FileNumService fileNumService;

    //生成出门单号
    @Override
    public String OutFeeOrderNo() {
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
        //生成出门单号
        StringBuffer sb=new StringBuffer();
        sb.append("CM");
        sb.append(sf.format(now));
        sb.append(sixNumber);
        return "出门单号为："+sb;
    }

    //模糊查询菜名
    @Override
    public PageInfo<Vegetable> selectVege(String vegetableName,Long outFeeOrderId) {
        List<Vegetable> vegetableList =  vegetableMapper.selectByName(vegetableName);
        //查不到添加到临时菜品
        if (vegetableList != null){
            VegetableTemp vegetableTemp = VegetableTemp.builder()
                    .vegetableName(vegetableName)
                    .createSourceId(outFeeOrderId)
                    .sourceType(1)
                    .status(0)
                    .gmtCreate(new Date())
                    .build();
            vegetableTempMapper.insert(vegetableTemp);
        }
        PageInfo<Vegetable> vegetablePageInfo = new PageInfo<>();
        vegetablePageInfo.setData(vegetableList);
        return vegetablePageInfo;
    }

    //出门订单
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOutFeeOrder(OutFeeOrderVO outFeeOrderVO) {
        //保存出门收费单
        OutFeeOrder outFeeOrder = OutFeeOrder.builder()
                .staffId(outFeeOrderVO.getStaffId())
                .outFeeNo(outFeeOrderVO.getOutFeeNo())
                .entranceFeeCapacityId(outFeeOrderVO.getEntranceFeeCapacityId())
                .driverPlateNumber(outFeeOrderVO.getDriverPlateNumber())
                .outFee(outFeeOrderVO.getOutFee())
                .loadStatus(outFeeOrderVO.getLoadStatus())
                .status(1)
                .gmtCreate(new Date())
                .build();
        outFeeOrderMapper.insert(outFeeOrder);
        //保存出门货物照片
       outFeeOrderImageService.saveImage(outFeeOrderVO);
        //保存菜品
        OutFeeVegetableRelation outFeeVegetableRelation = OutFeeVegetableRelation.builder()
                .outFeeOrderId(Long.parseLong(outFeeOrderVO.getOutFeeNo()))
                .vegetableId(outFeeOrderVO.getVegetableId())
                .vegetableName(outFeeOrderVO.getVegetableName())
                .gmtCreate(new Date())
                .build();
        outFeeVegetableRelationMapper.insert(outFeeVegetableRelation);
        //保存车道信息
        DrivewayDic drivewayDic = DrivewayDic.builder()
                .gateDictId(outFeeOrderVO.getGateDictId())
                .driveway(outFeeOrderVO.getDriveway())
                .remark(outFeeOrderVO.getRemark())
                .gmtCreate(new Date())
                .build();
        drivewayDicMapper.insert(drivewayDic);
    }

    //查询当前/历史订单
    @Override
    public PageInfo<OutFeeOrder> selectOrderByTime(Long staffId, Integer type){
        List<OutFeeOrder> outFeeOrderList = new ArrayList<>();
        if (1 == type){
             outFeeOrderList = outFeeOrderMapper.selectOrderByTime(staffId);
        }else if (2 == type){
            outFeeOrderList = outFeeOrderMapper.selectOrderBydate(staffId);
        }
        PageInfo<OutFeeOrder> outFeeOrderPageInfo = new PageInfo<>();
        outFeeOrderPageInfo.setData(outFeeOrderList);
        return outFeeOrderPageInfo;
    }

    //车牌识别
    @Override
    public String plateNumber(MultipartFile file) {
        ResultData<String> resultData = null;
        String number = null;
        try {
            resultData = fileNumService.number(file);
        }catch (Exception e){
            e.printStackTrace();
            throw new BizException("未能识别，请重新上传图片");
        }
        if (resultData.isResult()){
            number = resultData.getData();
        }else {
            throw new BizException(resultData.getMsg());
       }
        return number;
    }
}
