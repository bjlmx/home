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

import cn.hutool.core.util.ObjectUtil;
import com.ruibing.home.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Baijl
 * 2020/10/12
 * 16:03
 * @description
 */
@Controller
@Api(value = "文件上传接口")
@RequestMapping(value = "file")
@Slf4j
public class FileController {


    @ApiOperation(value = "文件上传")
    @PostMapping(value = "uploadFile")
    @ResponseBody
    public String uploadFile(MultipartFile multipartFile) throws IOException {
        if(ObjectUtil.isEmpty(multipartFile)){
            throw BusinessException.of("文件为空");
        }
        try {
            String path="D:/uploadfile/";
            File file1 = new File(path);
            if(!file1.exists()){
                file1.mkdirs();
            }
            File file = new File(path+ multipartFile.getOriginalFilename());
            multipartFile.transferTo(file);
            return "上传成功";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @ApiOperation(value = "跳转")
    @GetMapping(value = "hello")
    public String hello(){
        return "hello";
    }

}
