package com.example.cxy.achitectureclass.dao;

import com.example.cxy.achitectureclass.common.dao.LogicDAO;
import com.example.cxy.achitectureclass.entity.ShopItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopitemDao extends LogicDAO<ShopItem,Long> {

    @Query(value = "select * from shop_item where shop_id = ?1", nativeQuery = true)
    List<ShopItem> findShopItemsByShopId(@Param("shopId") Long shopId);
}
