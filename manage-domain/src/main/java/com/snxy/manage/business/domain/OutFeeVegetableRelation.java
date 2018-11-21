package com.snxy.manage.business.domain;

import lombok.Builder;

import java.util.Date;

@Builder
public class OutFeeVegetableRelation {
    private Long id;

    private Long outFeeOrderId;

    private Long vegetableId;

    private String vegetableName;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte idDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOutFeeOrderId() {
        return outFeeOrderId;
    }

    public void setOutFeeOrderId(Long outFeeOrderId) {
        this.outFeeOrderId = outFeeOrderId;
    }

    public Long getVegetableId() {
        return vegetableId;
    }

    public void setVegetableId(Long vegetableId) {
        this.vegetableId = vegetableId;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
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

    public Byte getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Byte idDelete) {
        this.idDelete = idDelete;
    }
}