package com.snxy.manage.business.service.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliPayForInOutVO {
    private String appid;
    private String mch_id;
    private String auth_code;//支付宝授权码
    private String out_trade_no;//商户系统生成的唯一支付账号
    private String body;//商品描述
    private Integer businessType;//1,进门费2,进门费和押金;3,退押金;4,退进门费和押金  5. 撤销订单
    private String total_fee;//支付金额
}
