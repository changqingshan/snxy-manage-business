package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrdeerSheetVO {
    private Long id;

    private String orderNo;

    private Long creatorId;

    private String creator;

    private String senderName;

    private String senderMobile;

    private Long receiverOnlineUserId;

    private String receiverMobile;

    private String receiverName;

    private String receiverCompany;

    private Long driverOnlineUserId;

    private String driverName;

    private String driverMobile;

    private Long vehicleId;

    private String driverPlateNumber;

    private Date driverLeaveTime;

    private Date sendTime;

    private String startAddr;

    private String endAddr;

    private Float distance;

    private Date estArrivalTime;

    private Date actualArrivalTime;

    private Integer loadStatus;

    private Integer locationCertificate;

    private Integer qualityCertificate;

    private String qrcodeUrl;

    private Integer isAuthPay;

    private Integer infoIntegrity;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    private Long receiverCompanyId;

    private Integer createRoleType;

}
