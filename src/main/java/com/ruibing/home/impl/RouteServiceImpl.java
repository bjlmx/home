/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.impl;

import com.ruibing.home.common.PayResult;
import com.ruibing.home.dto.PayRequest;
import com.ruibing.home.service.PayService;
import com.ruibing.home.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** @author Baijl
 * 2020/9/25 
 * 15:09 
 * @description
 */
@Service
public class RouteServiceImpl implements RouteService {

    private Map<String, PayService> payServiceMap;
    @Autowired
    private Set<PayService> payServiceSet;
    @Override
    public PayResult allPay(PayRequest payRequest) {
       return payServiceMap.get(payRequest.getChannelNo()).epay(payRequest);
    }

    @PostConstruct
    public void initPayType(){
        payServiceMap=new HashMap<>();
        payServiceSet.forEach(x->payServiceMap.put(x.returnPayType(),x));
    }
}
