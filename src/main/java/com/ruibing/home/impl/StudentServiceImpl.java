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

import com.ruibing.home.exception.BusinessException;
import com.ruibing.home.service.AsyncService;
import com.ruibing.home.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Baijl
 * 2020/10/12
 * 14:09
 * @description
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private AsyncService asyncService;

    @Transactional
    @Override
    public void index() throws InterruptedException {
        asyncService.asyncTest();
       throw  BusinessException.of("抛出异常");
    }
}
