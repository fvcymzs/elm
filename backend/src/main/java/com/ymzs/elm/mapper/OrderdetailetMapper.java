package com.ymzs.elm.mapper;
import java.util.List;

import com.ymzs.elm.domain.Orderdetailet;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[orderdetailet]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Orderdetailet
*/
@Mapper
public interface OrderdetailetMapper extends BaseMapper<Orderdetailet> {
    List<Orderdetailet> selectAllByOrderid(@Param("orderid") Integer orderid);
}




