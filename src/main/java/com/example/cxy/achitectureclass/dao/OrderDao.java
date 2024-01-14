package com.example.cxy.achitectureclass.dao;

import com.example.cxy.achitectureclass.common.dao.LogicDAO;
import com.example.cxy.achitectureclass.entity.Customer;
import com.example.cxy.achitectureclass.entity.Order;
import com.example.cxy.achitectureclass.entity.Shop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDao extends LogicDAO<Order,Long> {

    @Query("SELECT o FROM Order o WHERE o.customer = :customer AND o.shop = :shop ")
    List<Order> findUnpaidOrderByCustomerAndShop(@Param("customer") Customer customer, @Param("shop") Shop shop);
}
