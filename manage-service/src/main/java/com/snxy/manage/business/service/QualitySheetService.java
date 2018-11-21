package com.snxy.manage.business.service;

import com.snxy.common.util.PageInfo;
import com.snxy.manage.business.domain.QualitySheet;
import com.snxy.manage.business.service.vo.SystemUserVO;

public interface QualitySheetService {
    QualitySheet qualitySheetByOrderId(Long deliveryOrderId);

    PageInfo<QualitySheet> qualitySheetList(Long onlineUserId);
    PageInfo searchWillBeQualitySheet(SystemUserVO systemUserVO,String searchName);
    PageInfo searchQualitySheet(SystemUserVO systemUserVO, String searchName);
    int    deleteQualitySheetById(String qualitySheetId);
    String createQualitySheet(String deliveryOrderId);
}
