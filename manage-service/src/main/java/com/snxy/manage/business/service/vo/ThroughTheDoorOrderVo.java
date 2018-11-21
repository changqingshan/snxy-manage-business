package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThroughTheDoorOrderVo {
    //订单号
    private String orderNo;
    //操作人员
    private String operaterName;
    //车型
    private String carType;
    //品类
    private String category;
    //车牌号
    private String platNumber;
    //数量
    private String load;
    //产地证明,检测证明
    private List<ValicateImageVO>certificates;
    //进门费
    private String theDoorFee;
    //押金
    private String theDeposit;
    //检测费
    private String detectCost;
    //总金额
    private String theTotalAmount;
    //缴费人姓名
    private String payName;
    //手机号
    private String payPhone;
    //货品照片
    private List<MultipartFile> goodImages;
    //备注
    private String remark;
}
