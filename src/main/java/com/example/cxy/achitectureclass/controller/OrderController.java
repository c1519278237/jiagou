package com.example.cxy.achitectureclass.controller;


import com.example.cxy.achitectureclass.dto.CreateOrderDto;
import com.example.cxy.achitectureclass.entity.Order;
import com.example.cxy.achitectureclass.service.OrderService;
import com.example.cxy.achitectureclass.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "订单实体的控制器")
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody CreateOrderDto createOrderDto) {
        Order order = orderService.createOrder(createOrderDto.getCustomerId(), createOrderDto.getShopId());
        return ResponseEntity.ok("订单创建成功，订单ID: " + order.getId());
    }

    @ApiOperation(" 删除未支付订单")
    @GetMapping("/deleteOrder")
    public boolean deleteOrder(@ApiParam("订单id") Long orderId) {
        return orderService.deleteOrder(orderId);
    }

    @ApiOperation("查看门店订单")
    @GetMapping("/shop/orders")
    public List<Order> getOrdersForShop(@RequestParam Long shopId) {
        return orderService.getOrdersForShop(shopId);
    }

    @ApiOperation("确认已支付的订单")
    @GetMapping("/confirmOrder")
    public boolean confirmOrder(@RequestParam Long orderId) {
        return orderService.confirmOrder(orderId);
    }

    @ApiOperation("取消已支付的订单")
    @GetMapping("/cancelOrder")
    public boolean cancelOrder(@RequestParam Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    @ApiOperation("支付订单")
    @GetMapping("/payorder")
    public boolean payorder(@RequestParam Long orderId) {
        return orderService.payorder(orderId);
    }


}
