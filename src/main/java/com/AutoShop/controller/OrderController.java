package com.AutoShop.controller;

import com.AutoShop.model.Order;
import com.AutoShop.repository.OrderRepository;
import com.AutoShop.service.OrderService;
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
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

}
