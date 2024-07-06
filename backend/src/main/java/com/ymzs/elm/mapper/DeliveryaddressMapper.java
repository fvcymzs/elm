package com.ymzs.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ymzs.elm.domain.Deliveryaddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[deliveryaddress]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Deliveryaddress
*/
@Mapper
public interface DeliveryaddressMapper extends BaseMapper<Deliveryaddress> {
    List<Deliveryaddress> selectAllByUserid(@Param("userid") String userid);
}




