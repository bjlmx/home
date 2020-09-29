/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruibing.home.dto.McCommonApprovalDto;

/** @author Baijl
 * 2020/9/19 
 * 16:21 
 * @description
 */
public class Demo2 {
    public static void main(String[] args) {
        McCommonApprovalDto jsonObject = JSONUtil.toBean("{\n" +
                "\"approvalStatus\":\"1\",\n" +
                "\"approvalDesc\":\"\",\n" +
                "\"approvalDate\":\"2020-01-01 00:00:00\",\n" +
                "\"approvalData\":\"{\\\"inOutSeq\\\":\\\"w0000001\\\"}\"\n" +
                "}", McCommonApprovalDto.class);
        System.out.println(jsonObject);
        JSONObject object = JSONUtil.parseObj(jsonObject.getApprovalData());
        System.out.println(object.getStr("inOutSeq"));
        //String inOutSeq = jsonObject.getStr("inOutSeq");
        //System.out.println(inOutSeq);
    }
}
