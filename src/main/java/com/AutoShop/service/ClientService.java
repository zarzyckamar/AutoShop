package com.AutoShop.service;

import com.AutoShop.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {
    Client saveClient(Client product);

}
