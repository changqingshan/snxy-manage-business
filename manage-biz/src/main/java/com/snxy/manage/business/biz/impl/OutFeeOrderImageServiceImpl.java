package com.snxy.manage.business.biz.impl;

import com.snxy.manage.business.dao.mapper.OutFeeOrderImageMapper;
import com.snxy.manage.business.domain.OutFeeOrderImage;
import com.snxy.manage.business.service.OutFeeOrderImageService;
import com.snxy.manage.business.service.vo.OutFeeOrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Slf4j
public class OutFeeOrderImageServiceImpl implements OutFeeOrderImageService {

    @Resource
    private OutFeeOrderImageMapper outFeeOrderImageMapper;

    //保存菜品图片
    @Override
    public void saveImage(OutFeeOrderVO outFeeOrderVO) {
        OutFeeOrderImage outFeeOrderImage = new OutFeeOrderImage();
        for (int i=0;i<outFeeOrderVO.getImageUrl().size();i++){
            String url = outFeeOrderVO.getImageUrl().get(i);
            outFeeOrderImage = OutFeeOrderImage.builder()
                    .outFeeOrderId(Long.parseLong(outFeeOrderVO.getOutFeeNo()))
                    .url(url)
                    .uploadTime(new Date())
                    .gmtCreate(new Date())
                    .build();
            outFeeOrderImageMapper.insert(outFeeOrderImage);
        }
    }
}
