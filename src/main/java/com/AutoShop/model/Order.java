package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column
    private String datetime;


    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="id_vehicle")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client")
    private Client client;



    public Order (String datetime, Vehicle vehicle, Client client){
        this.datetime = datetime;
        this.vehicle = vehicle;
        this.client =client;

    }
}
