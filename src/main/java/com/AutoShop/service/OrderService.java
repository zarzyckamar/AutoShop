package com.AutoShop.service;

import com.AutoShop.model.Order;

import java.util.List;
import java.util.Optional;


public interface OrderService {

    Iterable<Order> listAllOrders();

    Optional<Order> findOrderById(Long idOrder);

}
