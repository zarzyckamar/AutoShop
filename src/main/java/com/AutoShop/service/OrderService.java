package com.AutoShop.service;

import com.AutoShop.model.Order;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

import java.util.Optional;


public interface OrderService {

    Iterable<Order> listAllOrders();

    Optional<Order> findOrderById(Long idOrder);


    ResponseEntity<InputStreamResource> ordersReportMethod(Long orderId);
}
