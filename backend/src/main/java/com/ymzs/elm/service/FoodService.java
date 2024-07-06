package com.ymzs.elm.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ymzs.elm.domain.Food;
import com.ymzs.elm.vo.res.FoodWithQuantityVO;

/**
* @author ymzs
* @description 针对表[food]的数据库操作Service
*/
public interface FoodService extends IService<Food> {

    List<Food> getFoodList(Integer businessid);

    List<FoodWithQuantityVO> getFoodListWithQuantity(String userid, Integer businessid);

}
