package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.EntryFee;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface EntryFeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EntryFee record);

    int insertSelective(EntryFee record);

    EntryFee selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EntryFee record);

    int updateByPrimaryKey(EntryFee record);

    void updateByEntryFee(String orderId, BigDecimal actualFee, Date date);

    EntryFee selectEntryFeeByOrderId(Long orderId);

    int updateStatusByOrderId(@Param("orderId") Long orderId, @Param("status") Integer status ,@Param("date") Date date);//修改支付状态
}