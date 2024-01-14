package com.example.cxy.achitectureclass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 19:43
 * @copyright www.cxy.com
 */
@Getter
@Setter
public class UserInfoDto {

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("用户类型 type 0 ： 顾客  1： 商家")
    private Integer type;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("名字")
    private String name;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("地址")
    private String addr;
}
