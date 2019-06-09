package com.AutoShop.service;

import com.AutoShop.model.Order;

import java.util.List;


public interface OrderService {

    Iterable<Order> listAllOrders();

    List<Order> findAll();
}
