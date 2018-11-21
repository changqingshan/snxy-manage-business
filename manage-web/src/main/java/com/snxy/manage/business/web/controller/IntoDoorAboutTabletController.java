package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import com.snxy.manage.business.service.OrderService;
import com.snxy.manage.business.service.vo.OrderFeeVO;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/tablet")
@Slf4j
public class IntoDoorAboutTabletController {

    @Resource
    private OrderService orderService;

    //设置检测证明有效性
    @RequestMapping("/proves/status")
    public ResultData provesStatus(SettingProvesInvalidVO settingProvesInvalidVO){
        orderService.setProvesStatus(settingProvesInvalidVO);
        return ResultData.success("");
    }

    //调整费用
    @RequestMapping("/updateOrder/cost")
    public ResultData updateOrderCost(OrderFeeVO orderFeeVO){
        orderService.updateOrderFee(orderFeeVO);
        return ResultData.success("");
    }
}
