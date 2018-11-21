package com.snxy.manage.business.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualitySheet {
    private Long id;

    private String code;

    private Long deliveryOrderId;

    private Float weight;

    private Long vegetableCategoryId;

    private String categoryName;

    private String vehiclePlateNumber;

    private String productionLocation;

    private Date checkTime;

    private String qrcodeUrl;

    private Integer status;

    private Integer qualified;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;
    private BigDecimal checkFee;
    private Integer isPay;

    public BigDecimal getCheckFee() {
        return checkFee;
    }

    public void setCheckFee(BigDecimal checkFee) {
        this.checkFee = checkFee;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getDeliveryOrderId() {
        return deliveryOrderId;
    }

    public void setDeliveryOrderId(Long deliveryOrderId) {
        this.deliveryOrderId = deliveryOrderId;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Long getVegetableCategoryId() {
        return vegetableCategoryId;
    }

    public void setVegetableCategoryId(Long vegetableCategoryId) {
        this.vegetableCategoryId = vegetableCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getProductionLocation() {
        return productionLocation;
    }

    public void setProductionLocation(String productionLocation) {
        this.productionLocation = productionLocation;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getQrcodeUrl() {
        return qrcodeUrl;
    }

    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQualified() {
        return qualified;
    }

    public void setQualified(Integer qualified) {
        this.qualified = qualified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}