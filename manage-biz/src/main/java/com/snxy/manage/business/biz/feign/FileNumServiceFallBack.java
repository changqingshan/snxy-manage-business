package com.snxy.manage.business.biz.feign;

import com.snxy.common.response.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileNumServiceFallBack implements FileNumService {

    @Override
    public ResultData<String> number(MultipartFile file) {
        return  ResultData.fail("车牌号识别失败");
    }
}
