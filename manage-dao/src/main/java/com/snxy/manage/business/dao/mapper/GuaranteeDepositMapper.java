package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.GuaranteeDeposit;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface GuaranteeDepositMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GuaranteeDeposit record);

    int insertSelective(GuaranteeDeposit record);

    GuaranteeDeposit selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GuaranteeDeposit record);

    int updateByPrimaryKey(GuaranteeDeposit record);
    GuaranteeDeposit selectGuaranteeByOrderId(Long orderId);
    int updateStatusByOrderId(@Param("orderId") Long orderId,@Param("status") Integer status,@Param("date") Date date);
}