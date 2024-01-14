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
@Table(name = "Shop")
public class Shop extends LogicEntity {

    @Column(name = "shop_name")
    private String shopName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    @JsonIgnore
    private Business business;

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
    private Set<ShopItem> shopItems = new LinkedHashSet<>();;


    @JsonBackReference
    public Set<Order> getOrders() {
        return orders;
    }

    @JsonBackReference
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public String getShopName() {
        return shopName;
    }



    public void setShopName(String shopName) {
        this.shopName=shopName;
    }

    public Long getBusinessid() {
        return business.getId() ;
    }


}
