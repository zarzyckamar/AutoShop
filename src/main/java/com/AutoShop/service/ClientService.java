package com.AutoShop.service;

import com.AutoShop.model.Client;

import java.util.Optional;

public interface ClientService {

    Iterable<Client> listAllClients();

    Optional<Client> getById(Long id);

    String addClient(Client client);

    void deleteClient(Long id);

    Client replaceClient (Long id, Client newClient);
}
