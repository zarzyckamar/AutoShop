package com.AutoShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("bike")
@Table(name = "BIKE")
public class Bike extends Vehicle {

    @Column(name = "GEARS")
    private int numberOfDerailleurGears;

    @Column(name ="COLOUR")
    private String colour;

    public Bike(){}

    public Bike(String name, int price, int numberOfDerailleurGears, String colour){
        super.setName(name);
        super.setPrice(price);
        this.numberOfDerailleurGears=numberOfDerailleurGears;
        this.colour=colour;
    }
}
