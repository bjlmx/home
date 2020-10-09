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
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/** @author Baijl
 * 2020/9/29 
 * 14:56 
 * @description
 */
@Data
@ApiModel(value = "学生测试实体")
public class Student implements Serializable {
    private static final long serialVersionUID = -6889875458163370344L;
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
    @AssertFalse(message = "必须为false")
    @ApiModelProperty(value = "标识")
    private Boolean flag;
    @Range(max = 5,min = 2)
    @ApiModelProperty(value = "数量")
    private BigDecimal number;
    @Email(message = "不符合邮件格式")
    @NotNull
    @ApiModelProperty(value = "邮箱内容")
    private String email;
}
