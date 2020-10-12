/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test.drink;

/**
 * @author Baijl
 * 2020/10/10
 * 15:28
 * @description
 */
public class Mary extends Thread implements Drink{
    @Override
    public Boolean openBottle(Bottle bottle) {
        return bottle.getOpen();
    }

    @Override
    public void drinkWater() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Mary打开了瓶子开始喝水");
    }

    @Override
    public void drinkFailed() {
        System.out.println("Mary喝水失败");
    }

    @Override
    public void run() {
        try {
            drinkWater();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
