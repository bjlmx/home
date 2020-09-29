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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/** @author Baijl
 * 2020/9/29 
 * 14:56 
 * @description
 */
@Data
@ApiModel(value = "学生测试实体")
public class Student {
    @ApiModelProperty(value = "学生id")
    @NotNull(message = "学生id不能为空")
    private Integer id;
    @ApiModelProperty(value = "学生姓名")
    @NotBlank(message = "学生姓名不能为空")
    private String name;
    @ApiModelProperty(value = "课本集合")
    @Valid
    @Size(min = 2,max = 5)
    @NotNull(message = "books不能为空")
    private List<Book> books;
}
