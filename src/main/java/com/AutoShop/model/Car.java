package com.AutoShop.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("car")
@Table(name = "CAR")
public class Car extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name ="HP")
    private int horsePower;

    @Column(name ="SEATS")
    private int numberOfSeats;
}
