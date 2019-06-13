package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "PRODUCTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicle_type", discriminatorType = DiscriminatorType.STRING)
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private int price;

    public Vehicle(){}

    public Vehicle(String name, int price){
        this.name=name;
        this.price=price;
    }
}
