package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.EntryFee;

import java.math.BigDecimal;
import java.util.Date;

public interface EntryFeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EntryFee record);

    int insertSelective(EntryFee record);

    EntryFee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EntryFee record);

    int updateByPrimaryKey(EntryFee record);

    void updateByEntryFee(String orderId, BigDecimal actualFee, Date date);
}