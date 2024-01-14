package com.example.cxy.achitectureclass.service;

import com.example.cxy.achitectureclass.common.service.LogicService;
import com.example.cxy.achitectureclass.dao.ShopDao;
import com.example.cxy.achitectureclass.dao.ShopitemDao;
import com.example.cxy.achitectureclass.entity.Shop;
import com.example.cxy.achitectureclass.entity.ShopItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Nonnull;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 19:20
 * @copyright www.cxy.com
 */
@Service
public class ShopItemService extends LogicService<ShopitemDao, ShopItem, Long> {

    @Autowired
    private ShopDao shopDao;

    public ShopItemService(@Autowired ShopitemDao lr) {
        super(lr);
    }

    public List<ShopItem> shopItems(@Nonnull Long shopId) {
        return getDAO().findShopItemsByShopId(shopId);
    }

    public boolean downloadItem(Long shopItemId) {
        ShopitemDao shopitemDao = getDAO();
        ShopItem shopItem = shopitemDao.getReferenceById(shopItemId);
        shopItem.setUpload(0);
        shopitemDao.save(shopItem);
        return true;
    }

    //上架商品shopitem
    public boolean uploadItem(@RequestParam Long shopitemId) {
        ShopitemDao shopitemDao = getDAO();
        ShopItem shopItem = shopitemDao.getReferenceById(shopitemId);
        shopItem.setUpload(1);
        shopitemDao.save(shopItem);
        return true;

    }

    //新建商品shopitem
    @Transactional
    public List<ShopItem> createShopItem(@Nonnull Long shopId) {
        ShopitemDao shopitemDao = getDAO();
        Shop shop = shopDao.getReferenceById(shopId);
        ShopItem shopItem = new ShopItem();
        shopItem.setShop(shop);
        ShopItem save = shopitemDao.save(shopItem);
        return shopItems(save.getShop().getId());
    }
}
