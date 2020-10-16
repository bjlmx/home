/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test.staticProxy;

import java.math.BigDecimal;

/**
 * @author Baijl
 * 2020/10/16
 * 10:58
 * @description
 */
public class Customer {
    private BusinessSale businessSale;

    public Customer(BusinessSale businessSale) {
        this.businessSale = businessSale;
    }

    public void buyDisk(Integer number,BigDecimal bigDecimal){
        this.businessSale.saleDisk(number, bigDecimal);
        System.out.println("客户购买成功");
    }

    public static void main(String[] args) {
        //商家找厂家
        UDiskFactory taobao = new UDiskFactory("淘宝");
        //客户找商家
        BusinessSale shanCun = new BusinessSale(taobao, "闪存旗舰店");


        Customer customer = new Customer(shanCun);

        BigDecimal bigDecimal = customer.askPrice();
        System.out.println("客户得到价格"+bigDecimal);
        customer.buyDisk(5,bigDecimal);
    }

    public BigDecimal askPrice(){
        return this.businessSale.askPrice();
    }
}
