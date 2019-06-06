package com.AutoShop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("bike")
@Table(name = "BIKE")
public class Bike extends Vehicle {

    @Column(name = "GEARS")
    private int numberOfDerailleurGears;

    @Column(name ="COLOUR")
    private String colour;
}
