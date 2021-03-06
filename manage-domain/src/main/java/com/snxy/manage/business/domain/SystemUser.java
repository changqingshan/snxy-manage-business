package com.snxy.manage.business.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SystemUser {
    private Long id;

    private String account;

    private String mobile;

    private String chineseName;

    private String pwd;

    private Date regDate;

    private Byte accountStatus;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDelete;


}