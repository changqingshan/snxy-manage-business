package com.snxy.manage.business.biz.impl;

import com.snxy.manage.business.domain.OutFeeOrder;
import com.snxy.manage.business.service.OrderService;
import com.snxy.manage.business.service.OutFeeOrderService;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OutFeeOrderServiceTest {

    @Resource
    private OutFeeOrderService outFeeOrderService;
    @Resource
    private OrderService orderService;

    @Test
    public void selectOrderByTime(){
        List<OutFeeOrder> outFeeOrderList = outFeeOrderService.selectOrderByTime(1L,2);
        log.info("个数："+outFeeOrderList.size());
    }

    @Test
    public void provesStatus(){
        SettingProvesInvalidVO settingProvesInvalidVO = SettingProvesInvalidVO.builder()
                .orderId("1")
                .status("2")
                .build();
        orderService.setProvesStatus(settingProvesInvalidVO);
    }

    @Test
    public void outFeeOrderList(){
        List<OutFeeOrder> outFeeOrderList = outFeeOrderService.selectOrderByTime(1L,2);
            log.info("大小："+outFeeOrderList.size());
    }
}
