package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import com.snxy.manage.business.service.OutFeeOrderService;
import com.snxy.manage.business.service.vo.OutFeeOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/outFee")
@Slf4j
public class OutFeeOrderController {

    @Resource
    private OutFeeOrderService outFeeOrderService;

    //生成出门单号
    @RequestMapping("/outFeeOrderNo/new")
    public ResultData outFeeOrderNo(){
        String outFeeNo = outFeeOrderService.OutFeeOrderNo();
        return ResultData.success(outFeeNo);
    }

    //菜品品类搜索
    @RequestMapping("/vegetableName/list")
    public ResultData vegetableName(String vegetableName){
        List<String> vegetableNameList = outFeeOrderService.selectVege(vegetableName);
        return ResultData.success(vegetableNameList);
    }

    //出门订单收费
    @RequestMapping("/outFeeOrder/new")
    public ResultData outFeeOrder(OutFeeOrderVo outFeeOrderVo){
        outFeeOrderService.saveOutFeeOrder(outFeeOrderVo);
        return ResultData.success("");
    }
}
