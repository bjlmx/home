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

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.ruibing.home.common.CommonResult;
import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.domain.Student;
import com.ruibing.home.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.stream.Collectors;

/** @author Baijl
 * 2020/9/29 
 * 14:53 
 * @description
 */
@RestController
@RequestMapping("student")
@Api(tags = "测试学生模块")
@Slf4j
public class StudentController {
    @Autowired
    private AsyncService asyncService;
    @PostMapping(value = "post")
    @ApiOperation(value = "测试学生",notes = "进行学生验证框架的测试")
    @ReturnResult
    public Object getStudent(@Valid @RequestBody Student student, BindingResult bindingResult) throws InterruptedException {
        //language=JSON

        if(bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().stream().map(x ->
                    x.getField() + " " + x.getDefaultMessage()
            ).collect(Collectors.toList());
        }
        System.out.println("主线程"+Thread.currentThread().getName());
        asyncService.asyncTest();
        //language=JSON
        return student;
    }

//    @ApiOperation(value = "123",notes = "444")
//    @GetMapping(value = "333")
    public void code(HttpServletResponse response) throws IOException {
        //LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100, 6, 100);
        ServletOutputStream outputStream = response.getOutputStream();
        log.info(lineCaptcha.getCode());
        lineCaptcha.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }

    @GetMapping(value = "collect")
    public void collect(){
        String str= "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"demoData\",\n" +
                "  \"books\": {\n" +
                "    \"bookId\": 1,\n" +
                "    \"bookName\": \"demoData\"\n" +
                "  },\n" +
                "  \"flag\": true,\n" +
                "  \"number\": 1,\n" +
                "  \"email\": \"demoData\"\n" +
                "}";
        Student student = JSONUtil.toBean(str, Student.class);
        String s = JSONUtil.toJsonStr(student);
        String execute =
                HttpRequest.post("http://localhost:8050/student/post").body(s).execute().body();
        System.out.println(execute);
        CommonResult commonResult = JSONUtil.toBean(execute, CommonResult.class);
        System.out.println(commonResult);
    }
}
