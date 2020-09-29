/**************************************************************************
 * Copyright (c) 2006-2020 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：特殊监管区域信息管理系统
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.ruibing.home.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/** @author Baijl
 * 2020/9/29 
 * 14:59 
 * @description
 */
@Data
@ApiModel(value = "学生的课本实体类")
public class Book {
    @NotNull(message = "课本id不能为空")
    @ApiModelProperty(value = "课本id")
    private Integer bookId;
    @ApiModelProperty(value = "课本名称")
    @NotBlank(message = "课程名称不能为空")
    private String bookName;
}
