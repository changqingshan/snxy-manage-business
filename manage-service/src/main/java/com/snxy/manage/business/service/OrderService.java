package com.snxy.manage.business.service;

import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.service.vo.*;

public interface OrderService {
    OrderNoAndNameVO generateOrderNo(String  operatorName);
    String createOrder(ThroughTheDoorOrderVo throughTheDoorOrderVo);
    OrderVO getOrderInfoByOrderId(String orderId);
    String settingProvesInvalid(SettingProvesInvalidVO SettingProvesInvalidVO);
    PageInfo<OrdeerSheetVO> getOrderSheetVOList(SystemUserVO systemUserVO  ,String status);
}
