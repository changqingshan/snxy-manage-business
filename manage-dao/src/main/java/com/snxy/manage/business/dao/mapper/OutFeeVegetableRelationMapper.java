package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.OutFeeVegetableRelation;

public interface OutFeeVegetableRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutFeeVegetableRelation record);

    int insertSelective(OutFeeVegetableRelation record);

    OutFeeVegetableRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutFeeVegetableRelation record);

    int updateByPrimaryKey(OutFeeVegetableRelation record);
}