package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OutFeeOrderVO {

    private Long staffId;

    private String outFeeNo;

    private Long entranceFeeCapacityId;

    private String driverPlateNumber;

    private BigDecimal outFee;

    private Integer loadStatus;

    private Integer status;

    private Date gmtCreate;

    private Date gmtModified;

    private String vegetableName;

    private List<String> imageUrl;

    private String remark;

    private String driveway;

    private Long vegetableId;

    private Long gateDictId;
}
