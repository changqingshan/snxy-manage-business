package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.PayTotal;

public interface PayTotalMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PayTotal record);

    int insertSelective(PayTotal record);

    PayTotal selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PayTotal record);

    int updateByPrimaryKey(PayTotal record);
}