package com.AutoShop.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.DateTimeException;

@Data
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column
    private DateTime datetime;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="id_vehicle")
    private Vehicle vehicle;


    @JsonIgnoreProperties ({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_client")
    private Client client;

    public Order(){}

    public Order (DateTime datetime, Vehicle vehicle, Client client){
        this.datetime = datetime;
        this.vehicle = vehicle;
        this.client =client;

    }
}
