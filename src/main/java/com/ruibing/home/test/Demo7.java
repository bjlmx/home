/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;

/**
 * @author Baijl
 * 2020/10/13
 * 10:51
 * @description
 */
public class Demo7 {
    public static void main(String[] args) {
        Integer[] a=new Integer[]{1,2,3};
        ArrayList<Integer> integers = new ArrayList<>(a.length);
        CollUtil.addAll(integers,a);
        integers.add(4);
        integers.forEach(System.out::println);
    }
}
