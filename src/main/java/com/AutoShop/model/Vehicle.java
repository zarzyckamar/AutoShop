package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "PRODUCTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="vehicle_type",
        discriminatorType = DiscriminatorType.STRING)
@Entity
public class Vehicle {

    @OneToOne(mappedBy = "vehicle", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @Id
    private int id;

    @Column(name = "NAME")
    private String name;

}
