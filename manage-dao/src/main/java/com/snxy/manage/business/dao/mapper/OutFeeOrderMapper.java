package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.OutFeeOrder;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface OutFeeOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OutFeeOrder record);

    int insertSelective(OutFeeOrder record);

    OutFeeOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OutFeeOrder record);

    int updateByPrimaryKey(OutFeeOrder record);
    int updateStatusByOrderId(@Param("orderId") Long orderId, @Param("status") Integer status , @Param("date") Date date);//修改支付状态
}