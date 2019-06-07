package com.AutoShop.repository;

import com.AutoShop.model.Client;
import com.AutoShop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
