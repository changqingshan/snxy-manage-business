package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderFeeVO {
    private String orderId;//订单id

    private BigDecimal actualFee;//进门费用

    private BigDecimal checkFee;//检测费

    private Date gmtModified;//修改时间
}
