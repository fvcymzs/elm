package com.ymzs.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ymzs.elm.domain.Cart;
import com.ymzs.elm.domain.Orderdetailet;
import com.ymzs.elm.mapper.OrderdetailetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymzs.elm.service.OrderdetailetService;

/**
 * @author ymzs
 * @description 针对表[orderdetailet]的数据库操作Service实现
 */
@Service
@Transactional
public class OrderdetailetServiceImpl extends ServiceImpl<OrderdetailetMapper, Orderdetailet>
        implements OrderdetailetService {

    @Autowired
    private OrderdetailetMapper orderdetailetMapper;
            
    @Override
    public Boolean saveOrderdetailet(Integer orderid, List<Cart> carts) {
        List<Orderdetailet> orderdetailets = new ArrayList<>();
        
        for (Cart cart : carts) {
            Orderdetailet orderdetailet = new Orderdetailet();
            orderdetailet.setOrderid(orderid);
            orderdetailet.setFoodid(cart.getFoodid());
            orderdetailet.setQuantity(cart.getQuantity());
            orderdetailets.add(orderdetailet);
        }
        return saveBatch(orderdetailets);
    }

    @Override
    public List<Orderdetailet> listOrderdetailet(Integer orderid) {
        return orderdetailetMapper.selectAllByOrderid(orderid);
    }

}
