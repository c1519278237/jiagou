package com.example.cxy.achitectureclass.controller;

import com.example.cxy.achitectureclass.entity.Shop;
import com.example.cxy.achitectureclass.service.ShopService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "门店控制器")
@RestController
@RequestMapping("/shop")
public class ShopController {

    @Resource
    private ShopService shopService;

    @ApiOperation("商家创建shop")
    @PostMapping("/create")
    public List<Shop> create(@ApiParam("商家id") @RequestParam Long businessId, @ApiParam("商铺名称") @RequestParam String shopName) {
        return shopService.createShopForBusiness(businessId, shopName);
    }

    @ApiOperation("返回shop")
    @GetMapping("/shops")
    public List<Shop> getAllShops(@ApiParam("商家id") Long businessId) {
        return shopService.getAllShopsForBusiness(businessId);
    }

    @ApiOperation("删除门店")
    @GetMapping("/delete")
    public boolean delete(@ApiParam("商铺Id") Long shopId) {
        shopService.delete(shopId);
        return true;
    }

    @ApiOperation("更新门店")
    @GetMapping("/update")
    public boolean update(@ApiParam("商铺Id") Long shopId, @ApiParam("商铺名称") String name) {
        return shopService.update(shopId, name);
    }
}
