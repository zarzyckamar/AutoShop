package com.AutoShop.controller;

import com.AutoShop.model.Order;
import com.AutoShop.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/allOrders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> listOfOrders() {
        return orderService.listAllOrders();
    }

    @RequestMapping(value = "/faktura-pdf/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ordersReportMethod(@PathVariable("id") Long orderId) {
        return orderService.ordersReportMethod(orderId);
    }
}
