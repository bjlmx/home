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
 * 10:55
 * @description
 */
public class BusinessSale implements Business{
    //厂商
    private UDiskFactory uDiskFactory;
    //商家名称
    private String name;

    public BusinessSale() {
        this.name = name;
    }

    public BusinessSale(UDiskFactory uDiskFactory, String name) {
        this.uDiskFactory = uDiskFactory;
        this.name = name;
    }

    @Override
    public BigDecimal saleDisk(Integer number, BigDecimal bigDecimal) {
        //number 客户购买数量
        //BigDecimal 客户报价
//        BigDecimal decimal = this.askPrice();
//        System.out.println("商家价格"+decimal);
//        if(0==bigDecimal.compareTo(decimal)){
//            System.out.println("商家销售完成");
//           return bigDecimal.multiply(new BigDecimal(String.valueOf(number)));
//        }else {
//            return null;
//        }
        return this.uDiskFactory.saleDisk(number, bigDecimal.divide(new BigDecimal("20")));
    }

    /**
     * 客户向商家询价
     * @return
     */
    public BigDecimal askPrice(){
        return this.uDiskFactory.returnPrice().add(new BigDecimal("20"));
    }
}
