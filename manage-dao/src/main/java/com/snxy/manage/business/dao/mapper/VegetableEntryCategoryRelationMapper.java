package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.VegetableEntryCategoryRelation;

public interface VegetableEntryCategoryRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VegetableEntryCategoryRelation record);

    int insertSelective(VegetableEntryCategoryRelation record);

    VegetableEntryCategoryRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VegetableEntryCategoryRelation record);

    int updateByPrimaryKey(VegetableEntryCategoryRelation record);
}