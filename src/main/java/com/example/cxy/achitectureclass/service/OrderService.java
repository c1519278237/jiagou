package com.example.cxy.achitectureclass.service;

import com.example.cxy.achitectureclass.common.service.LogicService;
import com.example.cxy.achitectureclass.dao.CustomerDao;
import com.example.cxy.achitectureclass.dao.LineItemDao;
import com.example.cxy.achitectureclass.dao.OrderDao;
import com.example.cxy.achitectureclass.dao.ShopDao;
import com.example.cxy.achitectureclass.entity.Customer;
import com.example.cxy.achitectureclass.entity.Order;
import com.example.cxy.achitectureclass.entity.Shop;
import com.example.cxy.achitectureclass.dao.*;
import com.example.cxy.achitectureclass.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService extends LogicService<OrderDao, Order, Long> {

    @Autowired
    private ShopDao shopDao;

    @Autowired
    private LineItemDao lineItemDao;

    @Autowired
    private CustomerDao customerDao;

    public OrderService(@Autowired OrderDao lr) {
        super(lr);
    }


    //创建订单
    public Order createOrder(Long customerId, Long shopId) {
        // 根据顾客ID获取顾客信息
        Customer customer = customerDao.getReferenceById(customerId);
        Shop shop = shopDao.getReferenceById(shopId);
        OrderDao orderDao = getDAO();
        Order order = new Order();
        order.setCustomer(customer);
        order.setShop(shop);
        return orderDao.save(order);
    }


    public boolean deleteOrder(Long orderId) {
        OrderDao orderDao = getDAO();
        // 通过订单ID获取订单
        Order order = orderDao.getReferenceById(orderId);

        // 检查订单是否存在且未支付
        if (order.getState() == 0) {
            // 删除订单
            orderDao.deleteById(orderId);

            // 如果订单成功删除，将isDeleted标记设置为1
            order.setIsDeleted(1);
            order.setDeletedTime(new Date());
            orderDao.save(order);
            return true;
        } else {
            // 订单不存在或已支付，删除失败
            return false;
        }
    }

    // 商家获得门店的订单
    public List<Order> getOrdersForShop(Long shopId) {
        Shop shop = shopDao.getReferenceById(shopId);
        return new ArrayList<>(shop.getOrders());
    }


    public boolean confirmOrder(Long orderId) {
        OrderDao orderDao = getDAO();
        Order order = orderDao.getReferenceById(orderId);
        order.setState(1);
        orderDao.save(order);
        return true;
    }

    public boolean cancelOrder(Long orderId) {
        OrderDao orderDao = getDAO();
        Order order = orderDao.getReferenceById(orderId);
        order.setState(2);
        orderDao.save(order);
        return true;
    }

    public boolean payorder(Long orderId) {
        OrderDao orderDao = getDAO();
        Order order = orderDao.getReferenceById(orderId);
        order.setState(3);
        orderDao.save(order);
        return true;
    }

}
