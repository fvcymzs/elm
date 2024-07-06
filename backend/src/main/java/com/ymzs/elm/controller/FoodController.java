package com.ymzs.elm.controller;

import java.util.List;

import com.ymzs.elm.config.ElmProperties;
import com.ymzs.elm.domain.Food;
import com.ymzs.elm.domain.User;
import com.ymzs.elm.validation.ValidInfo;
import com.ymzs.elm.vo.res.FoodWithQuantityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymzs.elm.service.FoodService;

import jakarta.validation.constraints.NotNull;

/**
 * 食品相关
 */
@RestController
@RequestMapping("/food")
@Validated
public class FoodController {

    @Autowired
    private FoodService foodService;

    // 根据商家编号查询商家下的食品列表
    @GetMapping("/business/{businessid}")
    public List<Food> getFoodList(
            @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return foodService.getFoodList(businessid);
    }

    // 根据商家编号查询商家下的食品列表（包括购物车）
    @GetMapping("/business/{businessid}/with/quantity")
    public List<FoodWithQuantityVO> getFoodListWithQuantity(
            @RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return foodService.getFoodListWithQuantity(user.getUserid(), businessid);
    }
}
