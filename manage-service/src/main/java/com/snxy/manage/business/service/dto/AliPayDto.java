package com.snxy.manage.business.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliPayDto {
    private String version;
    private String charset;
    private String sign_type;
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;
    private String result_code;
    private String err_code;
    private String err_code_des;

    private String openid;
    private String transaction_id;
    private String pass_trade_no;
    private String out_trade_no;
    private String total_fee;
    private String coupon_fee;
    private String time_end;
    private String buyer_logon_id;
    private String fund_bill_list;
    private List<InnerFundBill> fund_bills;


    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InnerFundBill{
        private String amount;
        private String fund_channel;
        private String realAmount;
    }

}
