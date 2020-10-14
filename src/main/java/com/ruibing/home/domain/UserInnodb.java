package com.ruibing.home.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruibing.home.validation.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * (UserInnodb)实体类
 *
 * @author makejava
 * @since 2020-10-14 10:02:18
 */
@Data
@TableName("user_innodb")
@ApiModel(value = "用户示例类")
public class UserInnodb implements Serializable {
    private static final long serialVersionUID = 348393348367723579L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "id不能为空",groups = {UpdateGroup.class})
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    @NotEmpty(message = "用户名称不能为空")
    private String name;

    @ApiModelProperty(value = "用户性别，0男，1女")
    @NotNull(message = "性别不能为空")
    @Min(0)
    @Max(1)
    private Integer gender;
    @ApiModelProperty(value = "电话号码")
    @NotEmpty(message = "电话号码不能为空")
    private String phone;
    @ApiModelProperty(value = "用户性别")
    @TableField(exist = false)
    private String genderName;

}
