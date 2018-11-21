package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.Vegetable;

import java.util.List;

public interface VegetableMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vegetable record);

    int insertSelective(Vegetable record);

    Vegetable selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Vegetable record);

    int updateByPrimaryKey(Vegetable record);

    List<Vegetable> selectByName(String vegetableName);
}