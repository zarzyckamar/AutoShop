package com.AutoShop.controller;

import com.AutoShop.model.Client;
import com.AutoShop.model.Vehicle;
import com.AutoShop.repository.ClientRepository;
import com.AutoShop.repository.VehicleRepository;
import com.AutoShop.service.VehicleService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Data
@RestController
@RequestMapping(path="/")
@CrossOrigin(origins = "http://localhost:8081")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/allProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Vehicle> listOfOrders() {
        return vehicleService.listAllVehicles();
    }

}
