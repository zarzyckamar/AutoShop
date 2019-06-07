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
    public Client saveClient(Client product) {
        return clientRepository.save(product);
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.findById(id);
    }
}
