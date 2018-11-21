package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.VegetableDeliveryRelation;

import java.util.List;

public interface VegetableDeliveryRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VegetableDeliveryRelation record);

    int insertSelective(VegetableDeliveryRelation record);

    VegetableDeliveryRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VegetableDeliveryRelation record);

    int updateByPrimaryKey(VegetableDeliveryRelation record);
    List<VegetableDeliveryRelation> selectByOrderId(Long orderId);
}