package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import com.snxy.manage.business.service.OrderService;
import com.snxy.manage.business.service.PayService;
import com.snxy.manage.business.service.vo.AliPayForInOutVO;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;
import com.snxy.manage.business.service.vo.SystemUserVO;
import com.snxy.manage.business.service.vo.ThroughTheDoorOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/tablet")
@Validated
public class IntoDoorAboutTabletController {
    @Resource
    private OrderService OrderService;
    @Resource
    private PayService payService;
    //生成订单号
    @RequestMapping("/order/generator")
    public ResultData generateOrderNo(@RequestAttribute(value = "systemUser", required = false) SystemUserVO systemUserVO){
        //从系统用户中获取在先用户姓名
        String operatorName="";
      return ResultData.success(OrderService.generateOrderNo(operatorName));
    }
    //新建发货单
    @RequestMapping("/deliverOrder/Create")
    public ResultData createOrder(ThroughTheDoorOrderVo throughTheDoorOrderVo){

        return ResultData.success(OrderService.createOrder(throughTheDoorOrderVo));
    }
    //自动生成总金额(?)
    //扫码后展示发货单(获取发货订单详情)
    @RequestMapping("/deliverOrder/info")
    public ResultData getOrderInfo(String orderId){
        return ResultData.success(OrderService.getOrderInfoByOrderId(orderId));
    }

    //设置检测证明无效,产地证明无效
    @RequestMapping("/proves/set")
    public ResultData settingProvesInvalid(SettingProvesInvalidVO settingProvesInvalidVO){
        return ResultData.success(OrderService.settingProvesInvalid(settingProvesInvalidVO));
    }


    //进门发货单(当天，历史)
    @RequestMapping("/order/list")
   public ResultData getOrderList(@RequestAttribute(value = "systemUser", required = false) SystemUserVO systemUserVO,String status){
        return ResultData.success(OrderService.getOrderSheetVOList(systemUserVO,status));
   }


    //收费（支付 进(出)门扫码上传支付条码进行付款）
    @RequestMapping("ali/pay")
    public ResultData getPayTheBarcode(AliPayForInOutVO aliPayForInOutVO){
       return ResultData.success(payService.getPayInfo(aliPayForInOutVO));
    }

//    //查看检测报告
//    @RequestMapping("checkReport/search")
//    public ResultData getQualitySheetInfo(){
//        return null;
//    }
//    //订单查询接口
//    @RequestMapping
//    public ResultData getOrderPayInfo(){
//        return null;
//    }
//    //退款申请
//
//    //退款结果查询
//    @RequestMapping
//    public ResultData getRefundResult(){
//        return null;
//    }
//    //撤销订单
//    @RequestMapping
//    public ResultData cancelOrder(){
//        return null;
//    }
//    //微信反扫支付
//    @RequestMapping
//    public ResultData PayWeiChat(){
//        return null;
//    }
//    //微信支付交易查询
//    @RequestMapping
//    public ResultData getWeiChatPayInfo(){
//        return null;
//    }
//    //微信申请退款交易
//    @RequestMapping
//    public ResultData refundWeiChat(){
//        return null;
//    }
//    //微信退款交易查询
//    @RequestMapping
//    public ResultData getRefundWeiChatInfo(){
//        return null;
//    }
//    //微信撤销交易
//    @RequestMapping
//    public ResultData cacelWeiChatPay(){
//        return null;
//    }
}
