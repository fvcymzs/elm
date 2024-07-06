package com.ymzs.elm.service.impl;

import java.util.List;

import com.ymzs.elm.domain.Business;
import com.ymzs.elm.mapper.BusinessMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymzs.elm.service.BusinessService;

/**
 * @author ymzs
 * @description 针对表[business]的数据库操作Service实现
 */
@Service
@Transactional
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
        implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public List<Business> findBusinessByOrdertypeid(Integer ordertypeid) {
        return businessMapper.selectAllByOrdertypeid(ordertypeid);
    }

    @Override
    public List<Business> findBusinessByBusinessname(String businessname) {
        return businessMapper.selectAllByBusinessnameLike(businessname);
    }

    @Override
    public List<Business> findBusinessByBusinesaddress(String businessaddress) {
        return businessMapper.selectAllByBusinessaddressLike(businessaddress);
    }
}
