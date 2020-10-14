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

import com.ruibing.home.common.GenderEnun;
import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.domain.UserInnodb;
import com.ruibing.home.service.UserService;
import com.ruibing.home.validation.UpdateGroup;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Baijl
 * 2020/10/14
 * 10:41
 * @description
 */
@RestController
@RequestMapping("user")
@ReturnResult
@Api(tags = "用户模块")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("list")
    @ApiOperation(value = "查询用户列表")
    public List<UserInnodb> list(){
//        userService.exceptionTest();
        List<UserInnodb> list = userService.list();
        list.forEach(x->x.setGenderName(GenderEnun.getNameByCode(x.getGender())));
        return list;
    }

    @PostMapping("add")
    @ApiOperation(value = "新增用户")
    public Object add(@RequestBody @Validated UserInnodb userInnodb, BindingResult result){
//        userService.exceptionTest();
        if(result.hasErrors()){
           return result.getFieldErrors().stream().map(x->"异常字段:"+x.getField()+","+"异常原因:"+x.getDefaultMessage()).collect(Collectors.toList());
        }
        userInnodb.setId(null);
        return userService.save(userInnodb);
    }

    @DeleteMapping(value = "deleteUser/{id}")
    @ApiOperation(value = "删除用户")
    public boolean deleteUser(@PathVariable(name = "id")Integer id){
       return userService.removeById(id);
    }

    @PutMapping(value = "updateUser")
    @ApiOperation(value = "更新用户")
    public Object updateUser(@Validated(value = UpdateGroup.class) @RequestBody  UserInnodb userInnodb, BindingResult result){
        if(result.hasErrors()){
            return result.getFieldErrors().stream().map(x->"异常字段:"+x.getField()+","+"异常原因:"+x.getDefaultMessage()).collect(Collectors.toList());
        }
//        if(userService.updateById(userInnodb)){
//            return new CommonResult<>(ResultEnum.SUCCESS);
//        }else {
//            return new String("修改失败");
//        }
        return userService.updateById(userInnodb);
    }
}
