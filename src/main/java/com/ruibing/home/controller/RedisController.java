/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.controller;

import com.ruibing.home.common.CommonResult;
import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.common.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Baijl
 * 2020/10/15
 * 14:34
 * @description
 */
@RestController
@Api(tags = "缓存模块")
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取当前redis中所有的keys
     * @return
     */
    @GetMapping("keys")
    @ReturnResult
    @ApiOperation(value = "获取全部key")
    public List<String> allKeys(){
        return redisUtil.keys("o");
    }

    /**
     * 获取当前redis中所有的keys
     * @return
     */
    @PostMapping("values/{key}")
    @ReturnResult
    @ApiOperation(value="获取全部值")
    public List<String> valueByOneKey(@PathVariable("key") String key){
        return redisUtil.multiGet(redisUtil.keys(key));
    }

    /**
     * 设置string
     */
    @GetMapping("setString")
    @ApiOperation(value="设置string类型值")
    @ReturnResult
    public void setString(){
        redisUtil.setString("key","设置string");
    }
    /**
     * 获取string
     * @return
     */
    @GetMapping("getString")
    @ApiOperation(value="获取string类型值")
    public CommonResult<Object> getString(){
        return new CommonResult<>(redisUtil.getString("key"));
    }
    /**
     * 删除数据
     */
    @PostMapping("delete")
    @ApiOperation(value="删除指定key的数据")
    public void delete(String key) {
        redisUtil.delete(key);
    }

    /**
     * 删除数据
     */
    @PostMapping("deleteAll")
    @ApiOperation(value="清空所有数据")
    public void deleteAll() {
        redisUtil.deleteAll(redisUtil.keys("*"));
    }

}
