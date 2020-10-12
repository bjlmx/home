/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test.ticket;

/**
 * @author Baijl
 * 2020/10/10
 * 17:14
 * @description
 */
public class SaleTicket implements Runnable{
    //定义票的总数
    private Integer total = 100;

    //定义票的编号
    private Integer no = total+1;
    //定义一个线程同步对象
    private Object obj = new Object();
    @Override
    public void run() {
        while(true){
            //同步锁
            synchronized(this.obj){
                if(this.total > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String msg = Thread.currentThread().getName()+" 售出第   "+(this.no -this.total) +"  张票";
                    System.out.println(msg);
                    this.total--;
                }else{
                    System.out.println("票已售完，请下次再来！");
                    System.exit(0);
                }
            }
        }
    }
}
