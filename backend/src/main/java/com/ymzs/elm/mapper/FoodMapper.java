package com.ymzs.elm.mapper;
import java.util.List;

import com.ymzs.elm.domain.Food;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ymzs
* @description 针对表[food]的数据库操作Mapper
* @Entity com.ymzs.elm.domain.Food
*/
@Mapper
public interface FoodMapper extends BaseMapper<Food> {
    List<Food> selectAllByBusinessid(@Param("businessid") Integer businessid);
}




