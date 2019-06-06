package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "PRODUCTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicle_type", discriminatorType = DiscriminatorType.STRING)
@Entity
public class Vehicle {

    // One-to-one association that assumes both the source and target share the same primary key values. dlatego tu jest samo id, z order @oneToOne ktore mapuje id
    @Id
    private Long id;

    @JoinColumn(name = "NAME")
    private String name;

}
