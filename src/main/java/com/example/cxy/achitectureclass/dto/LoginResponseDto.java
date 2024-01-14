package com.example.cxy.achitectureclass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 15:26
 * @copyright www.cxy.com
 */
@Getter
@Setter
@Accessors(chain = true)
public class LoginResponseDto {

    @ApiModelProperty("类型 0：商家，1：顾客")
    private Integer type;

    @ApiModelProperty("是否登录成功")
    private boolean success;
}
