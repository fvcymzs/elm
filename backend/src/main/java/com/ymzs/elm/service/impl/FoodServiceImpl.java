package com.ymzs.elm.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ymzs.elm.domain.Food;
import com.ymzs.elm.mapper.FoodMapper;
import com.ymzs.elm.vo.res.FoodWithQuantityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymzs.elm.service.CartService;
import com.ymzs.elm.service.FoodService;

/**
 * @author ymzs
 * @description 针对表[food]的数据库操作Service实现
 */
@Service
@Transactional
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
        implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private CartService cartService;

    @Override
    public List<Food> getFoodList(Integer businessid) {
        return foodMapper.selectAllByBusinessid(businessid);
    }

    @Override
    public List<FoodWithQuantityVO> getFoodListWithQuantity(String userid, Integer businessid) {
        List<Food> foodList = getFoodList(businessid);
        List<FoodWithQuantityVO> foodWithQuantityList = new ArrayList<>();
        for (Food food : foodList) {
            FoodWithQuantityVO foodWithQuantity = new FoodWithQuantityVO(food);

            // 更新购物车中的数量
            Integer quantity = cartService.getQuantity(userid, businessid, food.getFoodid());
            foodWithQuantity.setQuantity(quantity);
            foodWithQuantityList.add(foodWithQuantity);
        }
        return foodWithQuantityList;
    }

}
