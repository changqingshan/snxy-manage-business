package com.snxy.manage.business.dao.mapper;


import com.snxy.manage.business.domain.OutFeeOrderImage;

public interface OutFeeOrderImageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutFeeOrderImage record);

    int insertSelective(OutFeeOrderImage record);

    OutFeeOrderImage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutFeeOrderImage record);

    int updateByPrimaryKey(OutFeeOrderImage record);
}