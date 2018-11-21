package com.snxy.manage.business.service;

import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.domain.OutFeeOrder;
import com.snxy.manage.business.domain.Vegetable;
import com.snxy.manage.business.service.vo.OutFeeOrderVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OutFeeOrderService {
    void saveOutFeeOrder(OutFeeOrderVO outFeeOrderVO);

    String OutFeeOrderNo();

    PageInfo<Vegetable> selectVege(String vegetableName,Long outFeeOrderId);

    PageInfo<OutFeeOrder> selectOrderByTime(Long staffId, Integer type);

    String plateNumber(MultipartFile file);
}
