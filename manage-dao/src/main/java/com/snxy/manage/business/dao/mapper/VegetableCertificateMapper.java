package com.snxy.manage.business.dao.mapper;


import com.snxy.manage.business.domain.VegetableCertificate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface VegetableCertificateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(VegetableCertificate record);

    int insertSelective(VegetableCertificate record);

    VegetableCertificate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(VegetableCertificate record);

    int updateByPrimaryKey(VegetableCertificate record);

    void insertCertificateList(@Param("vegetableCertificateList") List<VegetableCertificate> vegetableCertificateList);

    int updateCertificate(@Param("orderId") Long orderId, @Param("status") String status);


    void setProvesStatusByOrderId(@Param("orderId") String orderId,@Param("status") String status,@Param("date") Date date);

    List<VegetableCertificate> selectVOByOrderId(Long orderId);

    int updateCertificate(@Param("orderId") Long orderId,@Param("status") String status,@Param("now") Date now);
}