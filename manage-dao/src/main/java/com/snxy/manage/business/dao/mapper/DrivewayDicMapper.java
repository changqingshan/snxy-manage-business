package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.DrivewayDic;

public interface DrivewayDicMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DrivewayDic record);

    int insertSelective(DrivewayDic record);

    DrivewayDic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DrivewayDic record);

    int updateByPrimaryKey(DrivewayDic record);
}