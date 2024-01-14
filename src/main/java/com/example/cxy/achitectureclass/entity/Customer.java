package com.example.cxy.achitectureclass.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@DiscriminatorValue("1")
public class Customer extends User{

    @Column
    private String email;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new LinkedHashSet<>();

    @Column
    private String addr;

    @Column
    private String customerName;
}
