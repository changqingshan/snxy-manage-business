package com.snxy.manage.business.biz.impl;

import com.snxy.common.response.ResultData;
import com.snxy.manage.business.dao.mapper.DeliveryOrderMapper;
import com.snxy.manage.business.dao.mapper.PaySingleMapper;
import com.snxy.manage.business.dao.mapper.PayTotalMapper;
import com.snxy.manage.business.domain.DeliveryOrder;
import com.snxy.manage.business.domain.PaySingle;
import com.snxy.manage.business.domain.PayTotal;
import com.snxy.manage.business.service.PayService;
import com.snxy.manage.business.service.dto.AliPayDto;
import com.snxy.manage.business.service.vo.AliPayForInOutVO;
import com.snxy.manage.business.service.vo.AliPayResVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class PayServiceImpl implements PayService {
    @Resource
    private DeliveryOrderMapper deliveryOrderMapper;
    @Resource
    private PayTotalMapper PayTotalMapper;
    @Resource
    private PaySingleMapper paySingleMapper;
    @Override
    public AliPayResVO getPayInfo(AliPayForInOutVO aliPayForInOutVO) {
        String msg="";
        ResultData<AliPayDto>res=new ResultData<>();
        //调用支付接口
        Date now =new Date();
        AliPayDto aliPayDto =new AliPayDto();
        PayTotal payTotal=new PayTotal();
        PaySingle paySingle=new PaySingle();
        String orderNO=aliPayForInOutVO.getOut_trade_no();//获取订单号？检测单号？出门单号

                //进门费(查询出表里的总金额与交付金额进行比对)
                //用订单号查出发货订单
                DeliveryOrder deliveryOrder = deliveryOrderMapper.selectAllByOrderNo(orderNO);
                String payFee=aliPayForInOutVO.getTotal_fee();//支付的金额
                Long totalFee=deliveryOrder.getTotalFee();//需要的总金额
                if("0".equals(res.getCode())) {
                    PaySingle.builder()
                            .gmtCreate(now)
                            .payFee(Integer.parseInt(payFee))
                            .outTradeNo(getOutTransString())
                            .sourceOrderNo(orderNO)
                            .refundFee(0)
                            .isDelete((byte)0)
                            .netPayFee(Integer.parseInt(payFee))
                            .payStatus(1)
                            .build();
                    //查询
                    if (Long.parseLong(payFee) < totalFee) {
                        //查询以前支付的记录
                        //部分支付，生成out_trade_no
                        PayTotal.builder()
                                .gmtCreate(now)//创建时间
                                .isDelete((byte) 0)
                                .payStatus(3)//部分支付
                                .sourceOrderNo(orderNO)//订单号
                                .payFee(Integer.parseInt(payFee))//支付金额
                                .netPayFee(Integer.parseInt(payFee))//净支付金额
                                .refundFee(0)//退费金额
                                .sourceOrderType(1)//货运单
                                .build();
                    } else {
                        //全部支付
                        payTotal= PayTotal.builder()
                                .gmtCreate(now)//创建时间
                                .isDelete((byte) 0)
                                .payStatus(1)//全部支付
                                .sourceOrderNo(orderNO)//订单号
                                .payFee(Integer.parseInt(payFee))//支付金额
                                .netPayFee(Integer.parseInt(payFee))//净支付金额
                                .refundFee(0)//退费金额
                                .sourceOrderType(1)//货运单
                                .build();
                        PayTotalMapper.insert(payTotal);
                        paySingle=  PaySingle.builder()
                                .gmtCreate(now)
                                .payFee(Integer.parseInt(payFee))
                                .outTradeNo(getOutTransString())
                                .sourceOrderNo(orderNO)
                                .refundFee(0)
                                .isDelete((byte)0)
                                .netPayFee(Integer.parseInt(payFee))
                                .payStatus(1)
                                .build();
                        paySingleMapper.insert(paySingle);
                    }
                }else if("1".equals(res.getCode())||"1001".equals(res.getCode())){
                    PaySingle.builder()
                            .gmtCreate(now)
                            .payFee(Integer.parseInt(payFee))
                            .outTradeNo(getOutTransString())
                            .sourceOrderNo(orderNO)
                            .refundFee(0)
                            .isDelete((byte)0)
                            .netPayFee(Integer.parseInt(payFee))
                            .payStatus(2)
                            .build();
                    AliPayResVO aiPayResVO=AliPayResVO.builder().code(res.getCode())
                            .msg(res.getMsg()).build();

                  return aiPayResVO;
                }


        return null;
    }
    //生成out_trannsNo
    public String getOutTransString(){
        return null;
    }
}
