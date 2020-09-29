/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.job;

import cn.hutool.core.date.LocalDateTimeUtil;
import com.ruibing.home.service.QuartzService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** @author Baijl
 * 2020/9/22 
 * 14:52 
 * @description
 */
public class DemoJob extends QuartzJobBean {
    @Autowired
    private QuartzService quartzService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(LocalDateTimeUtil.formatNormal(LocalDateTimeUtil.now()));
        System.out.println(jobExecutionContext.getJobDetail().getJobDataMap().get("msg"));
        TriggerKey key = jobExecutionContext.getTrigger().getKey();
        quartzService.quartzTest(key);
    }
}
