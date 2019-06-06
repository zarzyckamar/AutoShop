package com.AutoShop.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("car")
@Table(name = "CAR")
public class Car extends Vehicle {

    @Column(name ="HP")
    private int horsePower;

    @Column(name ="SEATS")
    private int numberOfSeats;
}
