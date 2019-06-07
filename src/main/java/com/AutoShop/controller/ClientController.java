package com.AutoShop.controller;


import com.AutoShop.model.Client;
import com.AutoShop.repository.ClientRepository;
import com.AutoShop.service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(path="/")
@CrossOrigin(origins = "http://localhost:8081")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientRepository clientRepository;


    @RequestMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllClients() {
        return clientRepository.findAll();
    }


    @RequestMapping(value = "/addclient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addNewClient(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        Client c1 = new Client();
        c1.setFirstName(firstName);
        c1.setLastName(lastName);
        c1.setAddress(address);
        clientRepository.save(c1);
        return "Saved";

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getByPublicId(@PathVariable("id") Integer publicId) {
        return clientService.getById(publicId);
    }

}
