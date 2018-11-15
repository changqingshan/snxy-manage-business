package com.snxy.manage.business.service;

import com.snxy.manage.business.service.vo.OutFeeOrderVo;

import java.util.List;

public interface OutFeeOrderService {
    void saveOutFeeOrder(OutFeeOrderVo outFeeOrderVo);

    String OutFeeOrderNo();

    List<String> selectVege(String vegetableName);
}
