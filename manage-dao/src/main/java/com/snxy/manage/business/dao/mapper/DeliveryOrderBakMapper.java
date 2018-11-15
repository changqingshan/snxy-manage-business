package com.snxy.manage.business.dao.mapper;


import com.snxy.manage.business.domain.DeliveryOrderBak;

public interface DeliveryOrderBakMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeliveryOrderBak record);

    int insertSelective(DeliveryOrderBak record);

    DeliveryOrderBak selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryOrderBak record);

    int updateByPrimaryKey(DeliveryOrderBak record);
}