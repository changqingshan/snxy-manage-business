package com.snxy.manage.business.domain;

import java.util.Date;

public class PayRefund {
    private Long id;

    private String sourceOrderNo;

    private Integer outTradeNo;

    private Integer outRefundNo;

    private Integer refundFee;

    private Integer refundType;

    private Integer refundStatus;

    private String remark;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceOrderNo() {
        return sourceOrderNo;
    }

    public void setSourceOrderNo(String sourceOrderNo) {
        this.sourceOrderNo = sourceOrderNo;
    }

    public Integer getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(Integer outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(Integer outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Integer getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Integer refundFee) {
        this.refundFee = refundFee;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
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