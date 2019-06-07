package com.AutoShop.controller;

import com.AutoShop.model.Client;
import com.AutoShop.model.Vehicle;
import com.AutoShop.repository.ClientRepository;
import com.AutoShop.repository.VehicleRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Data
@RestController
@RequestMapping(path="/")
@CrossOrigin(origins = "http://localhost:8081")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @RequestMapping(path="/allProducts")
    public @ResponseBody
    Iterable<Vehicle> getAllClients() {
        return vehicleRepository.findAll();
    }

}
