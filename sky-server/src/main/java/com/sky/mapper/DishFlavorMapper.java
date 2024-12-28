package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入菜品口味
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除菜品口味
     * @param dishId
     */
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品ids删除菜品口味
     * @param ids
     */
    void deleteByDishIds(List<Long> ids);

    /**
     * 根据菜品id查询菜品口味
     * @param id
     * @return List<DishFlavor>
     */
    List<DishFlavor> getByDishIdWithFlavor(Long id);
}
