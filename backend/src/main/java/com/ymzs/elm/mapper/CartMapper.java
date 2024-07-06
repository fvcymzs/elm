package com.ymzs.elm.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ymzs.elm.domain.Cart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[cart]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Cart
*/
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    int countByUseridAndBusinessid(@Param("userid") String userid, @Param("businessid") Integer businessid);

    List<Cart> selectByUseridAndBusinessid(@Param("userid") String userid, @Param("businessid") Integer businessid);

    Cart selectOneByUseridAndBusinessidAndFoodid(@Param("userid") String userid, @Param("businessid") Integer businessid, @Param("foodid") Integer foodid);

    int deleteByUseridAndBusinessid(@Param("userid") String userid, @Param("businessid") Integer businessid);
}




