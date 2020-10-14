/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.common;

import lombok.Data;

/** @author Baijl
 * 2020/9/19 
 * 20:41 
 * @description
 */
@Data
public class CommonResult<T> {
    private Integer status;

    private String code;

    private String msg;

    private T data;

    public CommonResult(T data) {
        this.data=data;
        this.code=ResultEnum.SUCCESS.getCode();
        this.msg=ResultEnum.SUCCESS.getMsg();
        this.status=1;
    }

    public CommonResult(ResultEnum resultEnum) {
            this.code=resultEnum.getCode();
            this.msg=resultEnum.getMsg();
            this.status=resultEnum.getStatus();

    }

    public CommonResult(ResultEnum resultEnum,String msg) {
            this.code=resultEnum.getCode();
            this.msg=msg;
            this.status=resultEnum.getStatus();

    }

    public CommonResult(ResultEnum resultEnum,T data) {
        this.code=resultEnum.getCode();
        this.msg=resultEnum.getMsg();
        this.status=resultEnum.getStatus();
        this.data=data;
    }

//    public CommonResult(String msg) {
//        this.errorCode = ResultEnum.FAILED.getCode();
//        this.errorMessage=msg;
//        this.status=-1;
//    }

    public CommonResult() {
        this.code=ResultEnum.SUCCESS.getCode();
        this.msg=ResultEnum.SUCCESS.getMsg();
        this.status=ResultEnum.SUCCESS.getStatus();
    }
}
