package com.snxy.manage.business.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AliCancelDto {
    private String version;
    private String charset;
    private String sign_type;
    private String return_code;
    private String return_msg;
    private String appid;
    private String mch_id;
    private String recall;
    private String result_code;
    private String err_code;
    private String err_code_des;
    private String nonce_str;
    private String sign;
}
