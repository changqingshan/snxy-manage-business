package com.snxy.manage.business.biz.impl;

import com.snxy.manage.business.dao.mapper.EntryFeeMapper;
import com.snxy.manage.business.dao.mapper.QualitySheetMapper;
import com.snxy.manage.business.dao.mapper.VegetableCategoryMapper;
import com.snxy.manage.business.dao.mapper.VegetableCertificateMapper;
import com.snxy.manage.business.service.OrderService;
import com.snxy.manage.business.service.vo.OrderFeeVO;
import com.snxy.manage.business.service.vo.SettingProvesInvalidVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private VegetableCertificateMapper vegetableCertificateMapper;
    @Resource
    private QualitySheetMapper qualitySheetMapper;
    @Resource
    private EntryFeeMapper entryFeeMapper;

    //设置检测证明有效性
    @Override
    public void setProvesStatus(SettingProvesInvalidVO settingProvesInvalidVO) {
        Date date = new Date();
        log.info("时间："+date);
        vegetableCertificateMapper.setProvesStatusByOrderId(settingProvesInvalidVO.getOrderId(),
                settingProvesInvalidVO.getStatus(),date);
    }

    //调整费用
    @Override
    public void updateOrderFee(OrderFeeVO orderFeeVO) {
        //修改检测费用
        Date date = new Date();
        qualitySheetMapper.updateByeEtryFee(orderFeeVO.getOrderId(),orderFeeVO.getCheckFee(),date);
        //修改进门费用
        entryFeeMapper.updateByEntryFee(orderFeeVO.getOrderId(),orderFeeVO.getActualFee(),date);
    }
}
