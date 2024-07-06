package com.ymzs.elm.controller;

import java.util.List;

import com.ymzs.elm.config.ElmProperties;
import com.ymzs.elm.domain.Cart;
import com.ymzs.elm.domain.User;
import com.ymzs.elm.validation.ValidInfo;
import com.ymzs.elm.vo.req.CartUpdateVO;
import com.ymzs.elm.vo.res.CartInfoVO;
import com.ymzs.elm.vo.res.CartWithFoodVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ymzs.elm.service.CartService;

import jakarta.validation.constraints.NotNull;

/**
 * 购物车相关
 */
@RestController
@RequestMapping("/cart")
@Validated
public class CartController {

    @Autowired
    private CartService cartService;

    // 统计当前用户在指定店家的购物车项数
    @GetMapping("/count/{businessid}")
    public Integer getCartItemCountForUserInStore(@RequestAttribute(ElmProperties.requestUser) User user,
            @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.getTotalQuantity(user.getUserid(), businessid);
    }

    // 当前用户在指定店家的购物车
    @GetMapping("/business/{businessid}")
    public List<Cart> listCart(@RequestAttribute(ElmProperties.requestUser) User user,
                               @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.listCart(user.getUserid(), businessid);
    }

    // 当前用户在指定店家的购物车（包含食品信息）
    @GetMapping("/business/{businessid}/with/food")
    public List<CartWithFoodVO> listCartWithFood(@RequestAttribute(ElmProperties.requestUser) User user,
                                                 @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.listCartWithFood(user.getUserid(), businessid);
    }

    // 当前用户在指定店家的购物车信息
    @GetMapping("/info/{businessid}")
    public CartInfoVO getCartInfo(@RequestAttribute(ElmProperties.requestUser) User user,
                                  @PathVariable("businessid") @NotNull(message = ValidInfo.BUSINESS_ID_NOT_NULL) Integer businessid) {
        return cartService.getCartInfo(user.getUserid(), businessid);
    }

    // 更新购物车
    @PutMapping("/update")
    public Boolean updateCart(@RequestAttribute(ElmProperties.requestUser) User user,
            @RequestBody @Validated CartUpdateVO cartUpdateVO) {
        return cartService.updateCart(user.getUserid(), cartUpdateVO.getBusinessid(), cartUpdateVO.getFoodid(),
                cartUpdateVO.getQuantity());
    }

}
