package com.snxy.manage.business.service;

import com.snxy.manage.business.service.vo.OrderFeeVO;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;

import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.service.vo.*;
public interface OrderService {

    void setProvesStatus(SettingProvesInvalidVO settingProvesInvalidVO);

    void updateOrderFee(OrderFeeVO orderFeeVO);

    OrderNoAndNameVO generateOrderNo(String  operatorName);

    String createOrder(ThroughTheDoorOrderVo throughTheDoorOrderVo);

    OrderVO getOrderInfoByOrderId(String orderId);

    String settingProvesInvalid(SettingProvesInvalidVO SettingProvesInvalidVO);

    PageInfo<OrdeerSheetVO> getOrderSheetVOList(SystemUserVO systemUserVO  ,String status);
}
