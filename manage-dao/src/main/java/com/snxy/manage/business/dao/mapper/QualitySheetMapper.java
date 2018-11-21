package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.QualitySheet;

import java.math.BigDecimal;
import java.util.Date;

public interface QualitySheetMapper {
    int deleteByPrimaryKey(QualitySheet key);

    int insert(QualitySheet record);

    int insertSelective(QualitySheet record);

    QualitySheet selectByPrimaryKey(QualitySheet key);

    int updateByPrimaryKeySelective(QualitySheet record);

    int updateByPrimaryKey(QualitySheet record);

    void updateByeEtryFee(String orderId, BigDecimal checkFee, Date date);
}