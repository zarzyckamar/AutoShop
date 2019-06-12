package com.AutoShop.service;

import com.AutoShop.model.Client;
import com.AutoShop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public String addClient(Client client) {
        clientRepository.save(client);
        return "Saved";
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client replaceClient (Long id, Client newClient) {
        return clientRepository.findById(id).map(client -> {
            client.setFirstName(newClient.getFirstName());
            client.setLastName(newClient.getLastName());
            client.setAddress(newClient.getAddress());
            return clientRepository.save(client);
        }).orElseGet(() -> {
            newClient.setId(id);
            return clientRepository.save(newClient);
        });
    }
}