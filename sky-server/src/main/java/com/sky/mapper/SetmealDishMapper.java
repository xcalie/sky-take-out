package com.sky.mapper;

import com.sky.annotation.AutoFill;
import com.sky.entity.SetmealDish;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetmealDishMapper {


    /**
     * 根据菜品id查询套餐id
     * @param dishIds
     * @return 套餐id集合
     */
    List<Long>  getSetmealIdsByDishIds(List<Long> dishIds);

    /**
     * 批量插入
     * @param setmealDishList
     */
    void insert(List<SetmealDish> setmealDishList);

    /**
     * 根据套餐id查询菜品
     * @param id
     * @return
     */
    List<SetmealDish> selectBySetmealId(Long id);

    /**
     * 根据套餐id删除
     * @param id
     */
    void deleteBySetmealId(Long id);
}
