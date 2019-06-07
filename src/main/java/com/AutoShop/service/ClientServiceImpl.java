package com.AutoShop.service;

import com.AutoShop.model.Client;
import com.AutoShop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Iterable<Client> listAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.findById(id);
    }

    public String addClient (String firstName, String lastName, String address) {
        Client c1 = new Client();
        c1.setFirstName(firstName);
        c1.setLastName(lastName);
        c1.setAddress(address);
        clientRepository.save(c1);
        return "Saved";
    }
}
