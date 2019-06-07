package com.AutoShop.service;

import com.AutoShop.model.Client;

public interface ClientService {

    Iterable<Client> listAllClients();

    Client getById(Integer id);

    String addClient(String firstName, String lastName, String address);

}
