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

/**
 * @author Baijl
 * 2020/10/14
 * 13:59
 * @description
 */
public enum GenderEnun {
    NAN(0,"男"),
    NV(1,"女");
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    GenderEnun(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private String name;
    public static String getNameByCode(Integer code){
        for (GenderEnun value : GenderEnun.values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }
}
