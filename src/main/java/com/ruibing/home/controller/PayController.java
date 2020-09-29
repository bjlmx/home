/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.controller;

import com.ruibing.home.common.PayResult;
import com.ruibing.home.dto.PayRequest;
import com.ruibing.home.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author Baijl
 * 2020/9/25 
 * 15:15 
 * @description
 */
@RestController
@RequestMapping("pay")
public class PayController {
    @Autowired
    private RouteService routeService;
    @PostMapping("paytest")
    private PayResult get(@RequestBody PayRequest payRequest){
        return routeService.allPay(payRequest);
    }
}
