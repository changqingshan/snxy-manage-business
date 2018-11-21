package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
    public class OrderVO {
    //订单号
    private String orderNo;
    //操作人员
    private String operaterName;
    //车型
    private String carType;
    //品类
    private List<String> category;
    //车牌号
    private String platNumber;
    //数量
    private Integer load;
    //产地证明,检测证明
    private List<ValicatePictureVO> certificates;
    //进门费
    private BigDecimal theDoorFee;
    //押金
    private BigDecimal theDeposit;
    //检测费
    private BigDecimal detectCost;
    //总金额
    private String theTotalAmount;
    //司机姓名
    private String driverName;
    //司机手机号
    private String driverPhone;
    //货品照片
    private List<byte[]> goodImages;
    //备注
    private String remark;

}
