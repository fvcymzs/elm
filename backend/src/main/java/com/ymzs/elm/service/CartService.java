package com.ymzs.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzs.elm.domain.Cart;
import com.ymzs.elm.vo.res.CartInfoVO;
import com.ymzs.elm.vo.res.CartWithFoodVO;

/**
 * @author ymzs
 * @description 针对表[cart]的数据库操作Service
 */
public interface CartService extends IService<Cart> {

    List<Cart> listCart(String userid, Integer businessid);

    Integer getTotalQuantity(String userid, Integer businessid);

    Integer getTotalQuantity(List<Cart> carts);

    Integer getQuantity(String userid, Integer businessid, Integer foodid);
    
    CartInfoVO getCartInfo(String userid, Integer businessid);

    CartInfoVO getCartInfo(List<Cart> carts);

    Boolean updateCart(String userid, Integer businessid, Integer foodid, Integer quantity);

    List<CartWithFoodVO> listCartWithFood(String userid, Integer businessid);

    Boolean deleteCart(String userid, Integer businessid);

}
