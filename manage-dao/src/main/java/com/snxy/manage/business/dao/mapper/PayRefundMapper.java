package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.PayRefund;

public interface PayRefundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayRefund record);

    int insertSelective(PayRefund record);

    PayRefund selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayRefund record);

    int updateByPrimaryKey(PayRefund record);
}