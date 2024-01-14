package com.example.cxy.achitectureclass.controller;

import com.example.cxy.achitectureclass.dto.LineItemInfo;
import com.example.cxy.achitectureclass.service.LineItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "挑选商品")
@RestController
@RequestMapping("/lineItem")
public class LineItemController {
    @Autowired
    private LineItemService lineItemService;

    @ApiOperation("获取订单中的商品")
    @PostMapping("/getLineItemsInfoForOrder")
    public List<LineItemInfo> getLineItemsInfoForOrder(@ApiParam("订单ID") @RequestParam Long orderId) {
        return lineItemService.getLineItemsInfoForOrder(orderId);
    }
}
