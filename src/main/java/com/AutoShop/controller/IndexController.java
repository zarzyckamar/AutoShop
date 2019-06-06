package com.AutoShop.controller;

import com.AutoShop.model.Client;
import com.AutoShop.service.ClientService;
import com.AutoShop.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class IndexController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {
        Client c1 = new Client("Malwina", "Chudzinka", "Poznan");
        clientService.saveClient(c1);
        return "Generated model";
    }
}
