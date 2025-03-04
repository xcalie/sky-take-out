package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@RestController("adminShopController")
@Slf4j
@RequestMapping("/admin/shop")
@Api(tags = "商铺接口")
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 商铺状态修改
     * @param status
     * @return
     */
    @PutMapping("/{status}")
    @ApiOperation("商铺状态修改")
    public Result setStatus(@PathVariable Integer status){
        log.info("商铺状态修改：{}", status == 1 ? "开启" : "关闭");
        redisTemplate.opsForValue().set(KEY, status);
        return Result.success();
    }

    /**
     * 商铺状态查询
     * @return
     */
    @GetMapping("/status")
    @ApiOperation("商铺状态查询")
    public Result<Integer> getStatus(){
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("商铺状态查询：{}", status == 1 ? "开启" : "关闭");
        return Result.success(status);
    }
}
