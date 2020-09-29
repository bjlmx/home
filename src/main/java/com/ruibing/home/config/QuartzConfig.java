/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.config;

import com.ruibing.home.job.DemoJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** @author Baijl
 * 2020/9/29 
 * 15:56 
 * @description
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail jobDetail() {
       return JobBuilder.newJob(DemoJob.class)
                .withIdentity("job1")
                .usingJobData("msg","hello world")
                .storeDurably().build();
    }
    @Bean
    public CronTrigger triggerJob() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/1 * * * * ?");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withIdentity("11","22")
                .withSchedule(cronScheduleBuilder)
                .build();
    }


}
