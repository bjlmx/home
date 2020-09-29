/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("分中心审批通用Dto")
public class McCommonApprovalDto implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6445050013821437486L;

	@ApiModelProperty("消息Id")
    private String messageId;

    @ApiModelProperty(value="审批状态", example="1")
    private int approvalStatus;

    @ApiModelProperty(value="审批备注 不通过时必填", example="已超出有效期")
    private String approvalDesc;

    @ApiModelProperty(value="审批时间 yyyy-MM-dd HH:mm:ss", example="2020-08-01 09:29:01")
    private String approvalDate;

    @ApiModelProperty("JSON字符串")
    private String approvalData;

    

}
