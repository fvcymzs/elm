package com.ymzs.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzs.elm.domain.Orders;
import com.ymzs.elm.vo.res.OrdersVO;

/**
* @author ymzs
* @description 针对表[orders]的数据库操作Service
*/
public interface OrdersService extends IService<Orders> {

    List<Orders> findOrdersByUserId(String userId);

    Orders createOrders(String userid, Integer businessid, Integer daid);

    OrdersVO getDetailetById(Integer orderId);

    Boolean payOrder(String userid, Integer orderId);

}
