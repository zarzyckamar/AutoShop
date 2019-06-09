package com.AutoShop.controller;

import com.AutoShop.model.Order;
import com.AutoShop.repository.OrderRepository;
import com.AutoShop.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(path="/")
@CrossOrigin(origins = "http://localhost:8081")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/allOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> listOfOrders() {
        return orderService.listAllOrders();
    }


}
