package com.example.cxy.achitectureclass.entity;

import com.example.cxy.achitectureclass.common.entity.LogicEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Item")
public class Item extends LogicEntity {

    @Column(name = "price")
    private String price;

    @Column(name = "itemName")
    private String itemName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    @JsonIgnore
    private Business business;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<ShopItem> shopItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails = new LinkedHashSet<>();


}
