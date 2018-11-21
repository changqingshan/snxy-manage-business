package com.snxy.manage.business.service;

import com.snxy.manage.business.service.vo.OrderFeeVO;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;

public interface OrderService {
    void setProvesStatus(SettingProvesInvalidVO settingProvesInvalidVO);

    void updateOrderFee(OrderFeeVO orderFeeVO);
}
