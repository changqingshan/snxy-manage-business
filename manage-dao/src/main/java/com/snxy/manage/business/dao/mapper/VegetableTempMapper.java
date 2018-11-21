package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.VegetableTemp;

public interface VegetableTempMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VegetableTemp record);

    int insertSelective(VegetableTemp record);

    VegetableTemp selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VegetableTemp record);

    int updateByPrimaryKey(VegetableTemp record);
}