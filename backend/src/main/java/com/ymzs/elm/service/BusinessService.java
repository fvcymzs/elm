package com.ymzs.elm.service;

import com.ymzs.elm.domain.Business;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ymzs
* @description 针对表[business]的数据库操作Service
*/
public interface BusinessService extends IService<Business> {

    List<Business> findBusinessByOrdertypeid(Integer ordertypeid);

    List<Business> findBusinessByBusinessname(String businessname);

    List<Business> findBusinessByBusinesaddress(String businessaddress);
}
