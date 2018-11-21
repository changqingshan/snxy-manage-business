package com.snxy.manage.business.web.controller;

import com.snxy.common.response.ResultData;
import com.snxy.manage.business.domain.QualitySheet;
import com.snxy.manage.business.service.QualitySheetService;
import com.snxy.manage.business.service.vo.SystemUserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;

@RestController
@Slf4j
@RequestMapping("/user")
public class CheckOrderController {
    @Resource
    private QualitySheetService qualitySheetService;

    //检测单详情
    @RequestMapping("/qualitySheet/info")
    public ResultData qualitySheetByOrderId(Long deliveryOrderId) {
        QualitySheet qualitySheet = qualitySheetService.qualitySheetByOrderId(deliveryOrderId);
        return ResultData.success(qualitySheet);
    }

    //新建检测单
    @RequestMapping("/qualitySheet/create")
    public ResultData createQualitySheet(String orderId) {
        return ResultData.success(qualitySheetService.createQualitySheet(orderId));
    }

    //待检测单列表(线上的，or根据菜品名称,or单号查询)
    @RequestMapping("/willBeQualitySheet/list")
    public ResultData searchWllBeQualitySheet(@RequestAttribute(value = "systemUser", required = false) SystemUserVO systemUserVO, String searchName) {
        //查询出所有的待检测单,已交押金
        return ResultData.success(qualitySheetService.searchWillBeQualitySheet(systemUserVO, searchName));
    }

    //我的检测证明(检验单列表,所有的,or根据菜品名称,or单号查询)
    @RequestMapping("/qualitySheet/list")
    public ResultData searchQualitySheet(@RequestAttribute(value = "systemUser", required = false) SystemUserVO systemUserVO, String searchName) {
        //查询出所有的检测证明
        return ResultData.success(qualitySheetService.searchQualitySheet(systemUserVO, searchName));
    }

    //查看检测报告(详情)
    @RequestMapping("/qualitySheetReport/view")
    public ResultData seeAboutQualitySheetReportInfo(@NotBlank(message = "检测号不能为空") String qualitySheetId) {
        //查看检测报告详情
        return null;
    }

    //删除检测单(线下)
    @RequestMapping("qualitySheet/delete")
    public ResultData deleteQualitySheet(@NotBlank(message = "检测号不能为空") String qualitySheetId) {
        qualitySheetService.deleteQualitySheetById(qualitySheetId);
        return ResultData.success("删除检测单成功");
    }

}
