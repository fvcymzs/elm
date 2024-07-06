package com.ymzs.elm.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ymzs.elm.domain.Business;
import com.ymzs.elm.domain.Cart;
import com.ymzs.elm.domain.Orderdetailet;
import com.ymzs.elm.domain.Orders;
import com.ymzs.elm.enums.OrderStatus;
import com.ymzs.elm.service.BusinessService;
import com.ymzs.elm.utils.DateFormatUtils;
import com.ymzs.elm.vo.res.CartInfoVO;
import com.ymzs.elm.vo.res.FoodWithQuantityVO;
import com.ymzs.elm.vo.res.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymzs.elm.mapper.OrdersMapper;
import com.ymzs.elm.service.CartService;
import com.ymzs.elm.service.FoodService;
import com.ymzs.elm.service.OrderdetailetService;
import com.ymzs.elm.service.OrdersService;

/**
 * @author ymzs
 * @description 针对表[orders]的数据库操作Service实现
 */
@Service
@Transactional
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
        implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private CartService cartService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private OrderdetailetService orderdetailetService;

    @Override
    public List<Orders> findOrdersByUserId(String userId) {
        return ordersMapper.selectAllByUserid(userId);
    }

    @Override
    public Orders createOrders(String userid, Integer businessid, Integer daid) {
        // 获取购物车
        List<Cart> carts = cartService.listCart(userid, businessid);
        CartInfoVO cartInfo = cartService.getCartInfo(carts);
        BigDecimal totalSettle = cartInfo.getTotalSettle();

        // 创建订单
        Orders orders = new Orders();
        orders.setUserid(userid);
        orders.setBusinessid(businessid);
        orders.setDaid(daid);
        orders.setOrdertotal(totalSettle);
        orders.setOrderdate(DateFormatUtils.currentTime());
        orders.setOrderstate(OrderStatus.UNPAID.getValue());
        ordersMapper.insert(orders);

        // 添加订单明细
        orderdetailetService.saveOrderdetailet(orders.getOrderid(), carts);
        // 清空购物车
        cartService.deleteCart(userid, businessid);
        return orders;

    }

    @Override
    public OrdersVO getDetailetById(Integer orderId) {
        Orders order = getById(orderId);
        OrdersVO orderVO = new OrdersVO(order);
        // 获取订单的所有订单项
        List<Orderdetailet> orderdetailetList = orderdetailetService.listOrderdetailet(orderId);

        // 遍历订单项获取订单项对应的食物及数量
        List<FoodWithQuantityVO> foodList = new ArrayList<>();
        for (Orderdetailet od : orderdetailetList) {
            Integer foodid = od.getFoodid();
            FoodWithQuantityVO foodWithQuantityVO = new FoodWithQuantityVO(foodService.getById(foodid));
            foodWithQuantityVO.setQuantity(od.getQuantity());
            foodList.add(foodWithQuantityVO);
        }
        orderVO.setFoodList(foodList);
        Business business = businessService.getById(order.getBusinessid());
        orderVO.setBusiness(business);
        return orderVO;
    }

    @Override
    public Boolean payOrder(String userid, Integer orderId) {
        Orders order = getById(orderId);
        if (order == null) {
            return false;
        }
        if (!order.getUserid().equals(userid)) {
            return false;
        }
        order.setOrderstate(OrderStatus.PAID.getValue());
        return updateById(order);
    }

}
