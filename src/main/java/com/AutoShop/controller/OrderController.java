package com.AutoShop.controller;

import com.AutoShop.model.Order;
import com.AutoShop.repository.OrderRepository;
import com.AutoShop.service.OrderService;
import com.AutoShop.utils.GeneratePdfReport;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

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

    @RequestMapping(value = "/faktura-pdf/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> ordersReportMethod(@PathVariable("id") Long orderId) {


        Optional<Order> order = orderService.findOrderById(orderId);
        ByteArrayInputStream bis = GeneratePdfReport.ordersReport(order);

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename = faktura.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
