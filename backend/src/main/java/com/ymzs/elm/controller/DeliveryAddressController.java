package com.ymzs.elm.controller;

import java.util.List;

import com.ymzs.elm.config.ElmProperties;
import com.ymzs.elm.domain.Deliveryaddress;
import com.ymzs.elm.domain.User;
import com.ymzs.elm.validation.ValidInfo;
import com.ymzs.elm.vo.req.DeliveryaddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymzs.elm.service.DeliveryaddressService;

import jakarta.validation.constraints.NotNull;

/**
 * 配送地址相关
 */
@RestController
@RequestMapping("/daddress")
@Validated
public class DeliveryAddressController {

    @Autowired
    private DeliveryaddressService deliveryaddressService;

    // 列出用户的所有配送地址
    @GetMapping("/list")
    public List<Deliveryaddress> listDeliveryAddressByUserId(@RequestAttribute(ElmProperties.requestUser) User user) {
        return deliveryaddressService.listDeliveryAddressByUser(user);
    }

    // 根据配送地址编号查询配送地址
    @GetMapping("/{daid}")
    public Deliveryaddress getDeliveryAddressById(
            @PathVariable("daid") @NotNull(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL) Integer daid) {
        return deliveryaddressService.getById(daid);
    }

    // 添加配送地址
    @PostMapping("/save")
    public Boolean saveDeliveryAddress(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody @Validated DeliveryaddressVO deliveryaddressVO) {
        return deliveryaddressService.saveDeliveryAddress(
                deliveryaddressVO.getDaid(),
                user.getUserid(),
                deliveryaddressVO.getContactname(),
                deliveryaddressVO.getContactsex(),
                deliveryaddressVO.getContacttel(),
                deliveryaddressVO.getAddress());
    }

    // 删除配送地址
    @DeleteMapping("/{daid}")
    public Boolean removeDeliveryAddressById(
            @PathVariable("daid") @NotNull(message = ValidInfo.DELIVERY_ADDRESS_ID_NOT_NULL) Integer daid) {
        return deliveryaddressService.removeById(daid);
    }

}
