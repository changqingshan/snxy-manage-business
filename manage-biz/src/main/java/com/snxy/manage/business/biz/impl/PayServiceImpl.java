package com.snxy.manage.business.biz.impl;

import com.snxy.manage.business.service.PayService;
import com.snxy.manage.business.service.dto.AliPayDto;
import com.snxy.manage.business.service.vo.AliPayForInOutVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PayServiceImpl implements PayService {
    @Override
    public String getPayInfo(AliPayForInOutVO aliPayForInOutVO) {
        AliPayDto aliPayDto =new AliPayDto();
        String orderId=aliPayForInOutVO.getOut_trade_no();//获取订单号？检测单号？出门单号
        switch(aliPayForInOutVO.getBusinessType()){
            case "1":
                //进门费
                break;
            case "2":
                //进门费和押金
                break;
            case "3":
                //退押金
                break;
            case "4":
                //退进门费和押金
                break;
            case"5":
                //撤销订单
                break;
        }
        //查询出订单id
        //修改所有的缴费状态
        return null;
    }
}
