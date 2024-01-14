package com.example.cxy.achitectureclass.entity;

import com.example.cxy.achitectureclass.common.entity.LogicEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @project: myachitecture
 * @description:
 * @author: cxy
 * @Date: 2024/1/13 10:50
 * @copyright www.cxy.com
 */
@Entity
@Getter
@Setter
@Table(name = "OrderDetail")
public class OrderDetail extends LogicEntity {

    @Column(name = "num")
    private Integer num;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;


}
