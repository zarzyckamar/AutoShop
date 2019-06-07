package com.AutoShop.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();


    public Client( String firstName, String lastName, String address) {

        this.firstName=firstName;
        this.lastName =lastName;
        this.address =address;
    }
    public Client(){}
}
