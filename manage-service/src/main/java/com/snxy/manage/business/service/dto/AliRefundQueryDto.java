package com.snxy.manage.business.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AliRefundQueryDto {
    private String version;
    private String charset;
    private String sign_type;
    private String return_code;
    private String return_msg;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String appid;
    private String mch_id;
    private String nonce_str;
    private String sign;

    private String transaction_id;
    private String pass_trade_no;
    private String out_trade_no;
    private String out_refund_no;
    private String pass_refund_no;
    private String refund_fee;
    private String refund_status;
    private String gmt_refund_pay;
    private String refund_detail_item_list;
}
