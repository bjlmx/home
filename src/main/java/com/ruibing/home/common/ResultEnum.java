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

/** @author Baijl
 * 2020/9/19 
 * 20:52 
 * @description
 */
public enum ResultEnum {

    SUCCESS("200","处理成功",1),
    FAILED("201","处理失败",-1),

    SAVE_SUCCESS("200","保存成功",1),
    SAVE_FAILED("201","保存失败",-1),

    DELETE_SUCCESS("203","删除成功",1),
    DELETE_FAILED("204","删除失败",-1),

    QUERY_SUCCESS("205","查询成功",1),
    QUERY_FAILED("206","查询失败",-1),

    UPDATE_SUCCESS("207","修改成功",1),
    UPDATE_FAILED("208","修改失败",-1);


    private String code;
    private String msg;
    private Integer status;

    ResultEnum(String code, String msg, Integer status) {
        this.code = code;
        this.msg = msg;
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultEnum() {
    }
}
