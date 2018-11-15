package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/outFee")
@Slf4j
public class OutFeeOrderController {

    //出门订单收费
    @RequestMapping("/")
    public ResultData outFeeOrder(){

        return ResultData.success("");
    }
}
