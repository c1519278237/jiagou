package com.example.cxy.achitectureclass.entity;

import com.example.cxy.achitectureclass.common.entity.LogicEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "LineItem")
public class LineItem extends LogicEntity {

    @Column
    private Long quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
