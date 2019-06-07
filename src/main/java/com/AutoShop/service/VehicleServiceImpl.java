package com.AutoShop.service;

import com.AutoShop.model.Vehicle;
import com.AutoShop.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public Vehicle saveVehicle (Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }
}
