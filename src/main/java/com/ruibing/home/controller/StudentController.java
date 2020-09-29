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

import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.domain.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

/** @author Baijl
 * 2020/9/29 
 * 14:53 
 * @description
 */
@RestController
@RequestMapping("student")
@Api(tags = "测试学生模块")
public class StudentController {

    @PostMapping(value = "post")
    @ApiOperation(value = "测试学生",notes = "进行学生验证框架的测试")
    @ReturnResult
    public Object getStudent(@Valid @RequestBody Student student, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().stream().map(x ->
                    x.getField() + " " + x.getDefaultMessage()
            ).collect(Collectors.toList());
        }
        return student;
    }
}
