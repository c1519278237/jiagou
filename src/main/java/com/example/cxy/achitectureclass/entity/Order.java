package com.example.cxy.achitectureclass.entity;

import com.example.cxy.achitectureclass.common.entity.LogicEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order extends LogicEntity {

    /**
     * 0:未支付
     * 1:已确认
     * 2:已退款
     * 3:已支付
     */
    @Column
    private int state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    @JsonIgnore
    private Shop shop;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();

    @JsonBackReference
    public Customer getCustomer() {
        return customer;
    }

    @JsonBackReference
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
