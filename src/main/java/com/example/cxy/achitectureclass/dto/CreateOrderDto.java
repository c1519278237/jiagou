package com.example.cxy.achitectureclass.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 19:35
 * @copyright www.cxy.com
 */
@Getter
@Setter
public class CreateOrderDto {

    @ApiModelProperty("顾客ID")
    private Long customerId;

    @ApiModelProperty("店铺ID")
    private Long shopId;
}
