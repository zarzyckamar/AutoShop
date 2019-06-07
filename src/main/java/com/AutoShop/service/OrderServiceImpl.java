package com.AutoShop.service;
import com.AutoShop.model.Order;
import com.AutoShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }
}
