package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SettingProvesInvalidVO {
    private String status;//1产地证明，2检测证明
    private String orderId;//订单id
}
