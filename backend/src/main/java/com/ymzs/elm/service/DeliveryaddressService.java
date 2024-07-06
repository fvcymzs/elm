package com.ymzs.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzs.elm.domain.Deliveryaddress;
import com.ymzs.elm.domain.User;

/**
 * @author ymzs
 * @description 针对表[deliveryaddress]的数据库操作Service
 */
public interface DeliveryaddressService extends IService<Deliveryaddress> {

    List<Deliveryaddress> listDeliveryAddressByUser(User user);

    Boolean saveDeliveryAddress(Integer daid, String userid, String contactname, Integer contactsex, String contacttel,
            String address);

}
