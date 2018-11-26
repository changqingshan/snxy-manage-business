package com.snxy.manage.business.service;

import com.snxy.manage.business.service.vo.AliPayForInOutVO;
import com.snxy.manage.business.service.vo.AliPayResVO;

public interface PayService {
    AliPayResVO getPayInfo(AliPayForInOutVO AliPayForInOutVO);

}
