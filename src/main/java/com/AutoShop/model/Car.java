package com.AutoShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@DiscriminatorValue("car")
@Table(name = "CAR")
public class Car extends Vehicle {

    @Column(name ="HP")
    private int horsePower;

    @Column(name ="SEATS")
    private int numberOfSeats;


    public Car(){}

    public Car(  String name, int price, int horsePower, int numberOfSeats){
        super.setName(name);
        super.setPrice(price);
        this.horsePower=horsePower;
        this.numberOfSeats=numberOfSeats;

    }
}
