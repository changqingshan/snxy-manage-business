package com.snxy.manage.business.dao.mapper;

import com.snxy.manage.business.domain.DeliveryOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeliveryOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DeliveryOrder record);

    int insertSelective(DeliveryOrder record);

    DeliveryOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DeliveryOrder record);

    int updateByPrimaryKey(DeliveryOrder record);
    Long selectByOrderNo(String orderNo);
    List<DeliveryOrder> selectByOperateIdAndStatus(@Param("userId") Long userId, @Param("status") String status);
    DeliveryOrder selectAllByOrderNo(String orderNo);
}