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

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/** @author Baijl
 * 2020/9/17 
 * 14:20 
 * @description
 */
@Data
@NoArgsConstructor
@ToString
@ApiModel(value = "动物参数类")
public class Animal   implements Serializable {
    private static final long serialVersionUID = -799481531088444420L;
    @NotNull(message = "类型不能为空")
    @ApiModelProperty(value = "动物类型")
    private Integer type;

    @ApiModelProperty(value = "动物优势",notes = "传值为integer类型")
    private Integer hobby;

    @Length(max = 5,min = 2)
    @NotEmpty(message = "名字不能为空")
    @ApiModelProperty(value = "动物名称")
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    @Future
    @NotNull(message = "时间不能为空")
    @ApiModelProperty(value = "动物日期",notes = "传递时间字符串",example = "2020-09-05 08:55:23")
    private LocalDateTime time;
    @Size(min = 2,max = 5)
    @NotEmpty(message = "集合不能为空")
    @ApiModelProperty(value = "integer集合",example = "1,2,3,4,5",notes = "不能为空")
    private List<Integer> list;
    @DecimalMin(value = "1.2")
    @DecimalMax(value = "2.0")
    @ApiModelProperty(value = "动物大小")
    private BigDecimal balance;
    @NotNull(message = "不能为空")
    @AssertFalse(message = "必须为false")
    private Boolean flag;

    public Animal(@NotNull(message = "类型不能为空") Integer type) {
        this.type = type;
    }
}
