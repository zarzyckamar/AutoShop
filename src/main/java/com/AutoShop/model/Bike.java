package com.AutoShop.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("bike")
@Table(name = "BIKE")
public class Bike extends Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "GEARS")
    private int numberOfDerailleurGears;

    @Column(name ="COLOUR")
    private String colour;
}
