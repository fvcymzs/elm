package com.ymzs.elm.controller;

import java.util.List;

import com.ymzs.elm.domain.Business;
import com.ymzs.elm.validation.ValidInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymzs.elm.service.BusinessService;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 商家相关
 */
@RestController
@RequestMapping("/business")
@Validated
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    // 根据商家编号查询商家信息
    @GetMapping("/business/{businessid}")
    public Business findBusinessByBusinessid(
            @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return businessService.getById(businessid);
    }

    // 根据点餐分类查询商家信息
    @GetMapping("/ordertype/{ordertypeid}")
    public List<Business> findBusinessByOrdertypeid(
            @PathVariable("ordertypeid") @NotNull(message = ValidInfo.ORDERTYPE_NOT_NULL) Integer ordertypeid) {
        return businessService.findBusinessByOrdertypeid(ordertypeid);
    }

    // 返回所有商家信息（分页）
    @GetMapping("/list")
    public IPage<Business> list(
            @RequestParam(defaultValue = "1") @Min(value = 1, message = ValidInfo.PAGE_LESS_THAN_ONE) Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize) {
        Page<Business> page = new Page<>(pageNum, pageSize);
        return businessService.page(page);
    }

    // 根据商家名称查询商家信息
    @GetMapping("/businessname/{businessname}")
    public List<Business> findBusinessByBusinessname(
            @PathVariable("businessname") @NotBlank(message = ValidInfo.BUSINESS_NAME_NOT_NULL) String businessname) {
        return businessService.findBusinessByBusinessname(businessname);
    }

    // 根据商家地址查询商家信息
    @GetMapping("/businessaddress/{businessaddress}")
    public List<Business> findBusinessByBusinessaddress(
            @PathVariable("businessaddress") @NotBlank(message = ValidInfo.BUSINESS_ADDRESS_NOT_NULL) String businessaddress) {
        return businessService.findBusinessByBusinesaddress(businessaddress);
    }

}
