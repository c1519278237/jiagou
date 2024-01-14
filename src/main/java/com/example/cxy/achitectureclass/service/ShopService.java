package com.example.cxy.achitectureclass.service;

import com.example.cxy.achitectureclass.common.service.LogicService;
import com.example.cxy.achitectureclass.dao.BusinessDao;
import com.example.cxy.achitectureclass.dao.ShopDao;
import com.example.cxy.achitectureclass.entity.Business;
import com.example.cxy.achitectureclass.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopService extends LogicService<ShopDao, Shop, Long> {

    @Resource
    BusinessDao businessDao;

    public ShopService(@Autowired ShopDao lr) {
        super(lr);
    }

    //创建shop
    @Transactional
    public List<Shop> createShopForBusiness(@Nonnull Long businessId, @Nonnull String shopName) {
        Business business = businessDao.getReferenceById(businessId);
        Shop shop = new Shop();
        shop.setShopName(shopName);
        shop.setCreateTime(new Date());
        shop.setBusiness(business);
        business.createshop(shop);
        // 保存商家和门店
        businessDao.save(business);
        return business.getShops();
    }

    //返回所有商铺
    public List<Shop> getAllShopsForBusiness(Long businessId) {
        Business business = businessDao.getReferenceById(businessId);
        return business.getShops().stream().filter(item->item.getIsDeleted() == 0).collect(Collectors.toList());
    }

    public boolean update(@Nonnull Long shopId, String name) {
        Shop shop = getDAO().getReferenceById(shopId);
        shop.setShopName(name);
        getDAO().save(shop);
        return true;
    }

    public void delete(Long shopId) {
        getDAO().deleteById(shopId);
    }
}
