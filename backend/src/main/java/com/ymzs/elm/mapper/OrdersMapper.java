package com.ymzs.elm.mapper;
import java.util.List;

import com.ymzs.elm.domain.Orders;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[orders]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Orders
*/
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {
    List<Orders> selectAllByUserid(@Param("userid") String userid);
}




