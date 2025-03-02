package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 添加购物车
     *
     * @param shoppingCart
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);


    /**
     * 根据id更新购物车数量
     *
     * @param shoppingCart
     */
    void updateNumberById (ShoppingCart shoppingCart);

    /**
     * 新增购物车
     *
     * @param shoppingCart
     */
    void insert(ShoppingCart shoppingCart);

    /**
     * 根据id清空购物车
     * @param userId
     */
    void deleteByUserId(Long userId);
}
