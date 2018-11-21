package com.snxy.manage.business.biz.feign;

import com.snxy.common.response.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@FeignClient(name = "snxy-ocr",fallbackFactory = FileNumServiceFallBack.class)
public interface FileNumService {

    //上传车牌号
    @RequestMapping(value = "/ocr/plateLicense",consumes = MULTIPART_FORM_DATA_VALUE)
    ResultData<String> number(@RequestPart("file") MultipartFile file);

}

