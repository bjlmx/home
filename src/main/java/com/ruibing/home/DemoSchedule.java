/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home;

import com.ruibing.home.job.DemoJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/** @author Baijl
 * 2020/9/22 
 * 14:54 
 * @description
 */
public class DemoSchedule {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //调度器创建（工厂模式）
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();
        //创建任务实例
        JobDetail jobDetail = JobBuilder.newJob(DemoJob.class).withIdentity("任务1", "第一组").usingJobData("标识1","数据1").build();

        //创建触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("触发器1", "第二组").startNow()
                //调度配置
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        //执行间隔
                        .withIntervalInSeconds(1).repeatForever()).build();

        //开始执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("任务开始");
        scheduler.start();
        //睡眠
        TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("任务中止");
    }
}
