package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.PaySingle;

public interface PaySingleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaySingle record);

    int insertSelective(PaySingle record);

    PaySingle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaySingle record);

    int updateByPrimaryKey(PaySingle record);
}