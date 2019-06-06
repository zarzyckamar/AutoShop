package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_vehicle", referencedColumnName = "id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_client", referencedColumnName = "id")
    private Client client;


    @Column
    private String datetime;


}
