package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.OutFeeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OutFeeOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutFeeOrder record);

    int insertSelective(OutFeeOrder record);

    OutFeeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutFeeOrder record);

    int updateByPrimaryKey(OutFeeOrder record);

    List<OutFeeOrder> selectOrderByTime(@Param("staffId") Long staffId);

    List<OutFeeOrder> selectOrderBydate(@Param("staffId") Long staffId);
}