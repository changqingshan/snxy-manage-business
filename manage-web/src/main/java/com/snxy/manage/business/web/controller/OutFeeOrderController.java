package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.domain.OutFeeOrder;
import com.snxy.manage.business.domain.Vegetable;
import com.snxy.manage.business.service.OutFeeOrderService;
import com.snxy.manage.business.service.vo.OutFeeOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

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
    public ResultData vegetableName(String vegetableName,Long outFeeOrderId){
        PageInfo<Vegetable> vegetableNameList = outFeeOrderService.selectVege(vegetableName,outFeeOrderId);
        return ResultData.success(vegetableNameList);
    }

    //车牌上传识别
    @RequestMapping("/file/plateNumber")
    public ResultData plateNumber(MultipartFile file){
        String number = outFeeOrderService.plateNumber(file);
        return ResultData.success(number);
    }

    //出门订单
    @RequestMapping("/outFeeOrder/new")
    public ResultData outFeeOrder(OutFeeOrderVO outFeeOrderVO){
        outFeeOrderService.saveOutFeeOrder(outFeeOrderVO);
        return ResultData.success("");
    }

    //出门单（今天/历史）
    @RequestMapping("/outFeeOrder/time")
    public ResultData outFeeOrderTime(Long staffId, Integer type){//type 1当天 2历史
        PageInfo<OutFeeOrder> outFeeOrderList = outFeeOrderService.selectOrderByTime(staffId,type);
        return ResultData.success(outFeeOrderList);
    }

}
