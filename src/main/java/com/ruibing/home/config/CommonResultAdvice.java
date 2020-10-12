/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.config;

import cn.hutool.core.annotation.AnnotationUtil;
import com.ruibing.home.common.CommonResult;
import com.ruibing.home.common.ReturnResult;
import com.ruibing.home.exception.BusinessException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/** @author Baijl
 * 2020/9/27 
 * 16:22 
 * @description 统一异常处理
 */
@RestControllerAdvice
public class CommonResultAdvice implements ResponseBodyAdvice {
    /**
     * 判断某方法是否具有自定义注解
     * @param returnType
     * @param converterType
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return AnnotationUtil.hasAnnotation(returnType.getContainingClass(), ReturnResult.class)||AnnotationUtil.hasAnnotation(returnType.getMethod(),ReturnResult.class);
    }

    /**
     * 通过body进行自定义返回对象的设置
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof CommonResult){

            return body;
        }
        return new CommonResult<>(body);
    }

    /**
     * 统一异常处理方法
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public CommonResult<Object> getException(BusinessException e){
        return new CommonResult<> (e.getMessage());
    }
}
