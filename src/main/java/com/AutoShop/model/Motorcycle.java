package com.AutoShop.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@DiscriminatorValue("motorcycle")
@Table(name = "MOTORCYCLE")
public class Motorcycle extends Vehicle {

    @Column(name ="HP")
    private int horsePower;

    @Column(name ="CAPACITY")
    private int capacity;
}

