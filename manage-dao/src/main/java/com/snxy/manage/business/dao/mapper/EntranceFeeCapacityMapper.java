package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.EntranceFeeCapacity;

public interface EntranceFeeCapacityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EntranceFeeCapacity record);

    int insertSelective(EntranceFeeCapacity record);

    EntranceFeeCapacity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EntranceFeeCapacity record);

    int updateByPrimaryKey(EntranceFeeCapacity record);
}