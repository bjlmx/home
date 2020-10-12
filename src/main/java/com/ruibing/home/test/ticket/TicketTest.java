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
 * 16:12
 * @description
 */
public class TicketTest {
    public static void main(String[] args) {

        /*Ticket ticket = new Ticket();
        ticket.setNumber(100);


            synchronized (ticket) {

                    SaleTicket1 saleTicket1 = new SaleTicket1(ticket);
                    SaleTicket2 saleTicket2 = new SaleTicket2(ticket);
                    SaleTicket3 saleTicket3 = new SaleTicket3(ticket);


                    saleTicket1.start();
                    saleTicket2.start();
                    saleTicket3.start();
            }*/
        //得到对象
        SaleTicket std = new SaleTicket();

        //把对象放入线程中
        Thread t1 = new Thread(std,"售票窗口1");
        Thread t2 = new Thread(std,"售票窗口2");
        Thread t3 = new Thread(std,"售票窗口3");
        Thread t4 = new Thread(std,"售票窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
