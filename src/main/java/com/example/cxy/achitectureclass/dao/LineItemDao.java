package com.example.cxy.achitectureclass.dao;

import com.example.cxy.achitectureclass.common.dao.LogicDAO;
import com.example.cxy.achitectureclass.entity.LineItem;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LineItemDao extends LogicDAO<LineItem,Long> {

    @Query(value = "select * from line_item where order_id = ?1", nativeQuery = true)
    List<LineItem> findUserByOrderById(@Param("username") Long orderId);
}
