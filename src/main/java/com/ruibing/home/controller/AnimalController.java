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

import cn.hutool.core.bean.BeanUtil;
import com.ruibing.home.common.CommonResult;
import com.ruibing.home.common.ResultEnum;
import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.domain.Animal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** @author Baijl
 * 2020/9/17 
 * 14:24 
 * @description
 */
@RestController
@Slf4j
@RequestMapping("test")
@Api(tags = "动物模块")
public class AnimalController {
    @GetMapping("get")
    public CommonResult<Object> getControl(){
        return new CommonResult<>(ResultEnum.SUCCESS);
    }

    @GetMapping("advice")
    @ReturnResult
    public ArrayList<Integer> getControl1(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        return integers;
    }

    @PostMapping(value = "valid")
    @ReturnResult
    @ApiOperation(value = "验证接口",notes = "用来测试验证框架")
    @ApiResponses({
            @ApiResponse(code = 200,message = "请求处理成功")
    })
    public Object valid(@Valid @RequestBody Animal animal, BindingResult result){
        //if(result.hasErrors()){
        //    List<FieldError> allErrors = result.getFieldErrors();
        //    for (FieldError allError : allErrors) {
        //        log.error("错误详情："+allError.getField()+allError.getDefaultMessage());
        //    }
        //    List<String> collect = allErrors.stream().map(x -> x.getField()+" "+x.getDefaultMessage()).collect(Collectors.toList());
        //    return collect;
        //}
        try {

            //return LocalDateTimeUtil.formatNormal(animal.getTime());
            ArrayList<Animal> animals = new ArrayList<>();
            Animal animal1 = new Animal();
            BeanUtil.copyProperties(animal,animal1);
            animals.add(animal);
            animals.add(animal1);
            HashMap<String, List<Animal>> hashMap = new HashMap<>();
            hashMap.put("animal",animals);
            return animals;
        }catch (Exception e){
            log.error("异常",e);
            return "时间格式显示失败";
        }

    }
}
