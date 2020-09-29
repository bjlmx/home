/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test.line;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;

/** @author Baijl
 * 2020/9/21 
 * 15:09 
 * @description
 */
@Slf4j
public class C implements Callable<String> {
    @Override
    public String call() throws Exception {
        log.info("callable接口测试");
        System.out.println("你好");
        return "success";
    }
}
