package com.sky.controller.admin;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.SetmealService;
import com.sky.vo.SetmealVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/setmeal")
@Api(tags = "套餐接口")
public class SetmealController {

    @Autowired
    private SetmealService setmealService;


    /**
     * 分页查询套餐
     *
     * @param setmealPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分页查询套餐")
    public Result<PageResult> page(SetmealPageQueryDTO setmealPageQueryDTO) {
        log.info("分页查询套餐：{}", setmealPageQueryDTO);
        PageResult pageResult = setmealService.pageQuery(setmealPageQueryDTO);
        return Result.success(pageResult);
    }


    /**
     * 新增套餐
     *
     * @param setmealDTO
     */
    @PostMapping
    @ApiOperation("新增套餐")
    @CacheEvict(cacheNames = "setmealCache", key = "#setmealDTO.categoryId")//key: setmealCache::100
    public Result add(@RequestBody SetmealDTO setmealDTO) {
        log.info("新增套餐：{}", setmealDTO);
        setmealService.add(setmealDTO);
        return Result.success();
    }


    /**
     * 根据id查询套餐
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据id查询套餐")
    public Result<SetmealVO> getById(@PathVariable Long id) {
        log.info("根据id查询套餐：{}", id);
        SetmealVO setmealVO = setmealService.getById(id);
        return Result.success(setmealVO);
    }


    /**
     * 修改套餐
     *
     * @param setmealDTO
     */
    @PutMapping
    @ApiOperation("修改套餐")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)//key: setmealCache 删除所有缓存
    public Result update(@RequestBody SetmealDTO setmealDTO) {
        log.info("修改套餐：{}", setmealDTO);
        setmealService.update(setmealDTO);
        return Result.success();
    }

    /**
     * 根据ids批量删除套餐
     *
     * @param ids
     */
    @DeleteMapping
    @ApiOperation("根据ids批量删除套餐")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)//key: setmealCache 删除所有缓存
    public Result delete(@RequestBody List<Long> ids) {
        log.info("根据ids批量删除套餐：{}", ids);
        setmealService.deleteById(ids);
        return Result.success();
    }

    /**
     * 启用、禁用套餐
     *
     * @param status
     * @param id
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用、禁用套餐")
    @CacheEvict(cacheNames = "setmealCache", allEntries = true)//key: setmealCache 删除所有缓存
    public Result StartOrStop(@PathVariable Integer status, Long id) {
        log.info("启用、禁用套餐：{}", id);
        setmealService.startOrStop(status, id);
        return Result.success();
    }
}
