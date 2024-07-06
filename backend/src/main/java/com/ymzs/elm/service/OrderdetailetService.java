package com.ymzs.elm.service;

import com.ymzs.elm.domain.Cart;
import com.ymzs.elm.domain.Orderdetailet;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ymzs
* @description 针对表[orderdetailet]的数据库操作Service
*/
public interface OrderdetailetService extends IService<Orderdetailet> {

    Boolean saveOrderdetailet(Integer orderid, List<Cart> carts);

    // 获取订单所有的订单项
    List<Orderdetailet> listOrderdetailet(Integer orderid);

}
