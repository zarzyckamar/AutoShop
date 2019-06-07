package com.AutoShop.repository;

import com.AutoShop.model.Order;
import com.AutoShop.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
