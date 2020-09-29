/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.service;

import com.ruibing.home.common.PayResult;
import com.ruibing.home.dto.PayRequest;

/** @author Baijl
 * 2020/9/25 
 * 14:44 
 * @description
 */
public interface PayService {
    PayResult epay(PayRequest request);

    String returnPayType();
}
