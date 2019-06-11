package com.AutoShop.controller;


import com.AutoShop.model.Client;
import com.AutoShop.repository.ClientRepository;
import com.AutoShop.service.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Data
@RestController
@RequestMapping(path = "/")
@CrossOrigin(origins = "http://localhost:8081")
public class ClientController {

    @Autowired
    private ClientService clientService;

    private ClientRepository clientRepository;

    @RequestMapping(value = "/allClients", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Client> listOfClients() {
        return clientService.listAllClients();
    }

    @RequestMapping(value = "/addClient", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String addNewClient(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        return clientService.addClient(firstName, lastName, address);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Client> getByPublicId(@PathVariable("id") Long publicId) {
        return clientService.getById(publicId);
    }

    @RequestMapping(value = "/deleteClient/{id}", method = RequestMethod.DELETE)
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return "DELETED";
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {
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
