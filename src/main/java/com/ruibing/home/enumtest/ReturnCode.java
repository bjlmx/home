/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.enumtest;

/** @author Baijl
 * 2020/9/24 
 * 15:05 
 * @description
 */
public enum ReturnCode implements ReturnStatus{
    SUCCESS(200,"成功"){
        @Override
        public void returnStatus() {
            System.out.println("处理成功");
        }
    },
    FAIL(500,"错误"){
        @Override
        public void returnStatus() {
            System.out.println("处理失败");
        }
    };
    private Integer code;
    private String msg;

    ReturnCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        ReturnCode.SUCCESS.returnStatus();
    }
}
