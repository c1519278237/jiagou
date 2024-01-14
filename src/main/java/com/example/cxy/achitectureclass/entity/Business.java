package com.example.cxy.achitectureclass.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@DiscriminatorValue("0")
public class Business extends User {

    @Column
    private String email;

    @Column
    private String realName;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<Item> items = new LinkedHashSet<>();


    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Shop> shops;

    @Column
    private String addr;


    public List<Shop> createshop(Shop shop){
        shops.add(shop);
        return shops;
    }



}
