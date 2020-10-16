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
 * 10:53
 * @description
 */
public class UDiskFactory implements Business {
    //厂家名称
    private String name;
    //厂家报价
    private BigDecimal price;


    public UDiskFactory(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal saleDisk(Integer number,BigDecimal bigDecimal) {
        //如果报价过高
        if(0==bigDecimal.compareTo(this.price)){
            System.out.println("厂家销售完成");
           return bigDecimal.multiply(new BigDecimal(String.valueOf(number)));
        }else {
            return null;
        }

    }

    /**
     * 返回商家报价
     * @return
     */
    public BigDecimal returnPrice(){
        BigDecimal bigDecimal = new BigDecimal("30");
        this.price = bigDecimal;
        System.out.println("厂家价格"+bigDecimal);
        return bigDecimal;
    }
}
