package com.example.cxy.achitectureclass.controller;

import com.example.cxy.achitectureclass.entity.ShopItem;
import com.example.cxy.achitectureclass.service.ShopItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "商品控制器")
@RestController
@RequestMapping("/shopItem")
public class ShopItemController {

    @Resource
    private ShopItemService shopItemService;

    @ApiOperation("门店商品列表")
    @GetMapping("/shopItems")
    public List<ShopItem> shopItems(@ApiParam("门店ID") @RequestParam Long shopId) {
        return shopItemService.shopItems(shopId);
    }

    @ApiOperation("上架商品·")
    @PostMapping("/upload")
    public boolean uploadItem(@RequestParam Long shopItemId) {
        return shopItemService.uploadItem(shopItemId);
    }

    @ApiOperation("下架商品·")
    @PostMapping("/download")
    public boolean downloadItem(@RequestParam Long shopItemId) {
        return shopItemService.downloadItem(shopItemId);
    }

    @ApiOperation("商家创建shopItem")
    @PostMapping("/create")
    public List<ShopItem> create(@ApiParam("门店ID") @RequestParam Long shopId) {
        return shopItemService.createShopItem(shopId);
    }
}
