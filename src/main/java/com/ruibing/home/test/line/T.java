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

import java.util.concurrent.FutureTask;

/** @author Baijl
 * 2020/9/21 
 * 14:40 
 * @description
 */
@Slf4j
public class T extends Thread{
    @Override
    public void run() {
        log.info("thread线程测试日志控制台打印");
        System.out.println("thread线程创建测试");
    }

    public static void main(String[] args) {
        new T().start();
        new Thread(new R()).start();
        FutureTask<String> task = new FutureTask<>(new C());
        new Thread(task).start();
    }
}
