package com.snxy.manage.business.biz.impl;

import com.snxy.manage.business.service.OutFeeOrderService;
import com.snxy.manage.business.service.vo.OutFeeOrderVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class OutFeeOrderServiceImpl implements OutFeeOrderService {
    @Resource
    private RedisTemplate redisTemplate;

    //生成出门单号
    @Override
    public String OutFeeOrderNo() {
        Integer lastQualityNo = (Integer) redisTemplate.opsForValue().get("qualityNo");
        String sixNumber;
        if (lastQualityNo == null || lastQualityNo.equals("")) {
            redisTemplate.opsForValue().set("qualityNo", 1);
            sixNumber= String.format("%06d", 1);
        } else {
            redisTemplate.opsForValue().set("qualityNo", lastQualityNo + 1);
            sixNumber= String.format("%06d",lastQualityNo + 1 );
        }
        Date now=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmss");
        //生成出门单号
        StringBuffer sb=new StringBuffer();
        sb.append("CM");
        sb.append(sf.format(now));
        sb.append(sixNumber);
        return "出门单号为："+sb;
    }

    //模糊查询菜名
    @Override
    public List<String> selectVege(String vegetableName) {
        return null;
    }

    @Override
    public void saveOutFeeOrder(OutFeeOrderVo outFeeOrderVo) {

    }
}
