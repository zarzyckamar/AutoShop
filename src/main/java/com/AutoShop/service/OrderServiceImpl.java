package com.AutoShop.service;
import com.AutoShop.model.Order;
import com.AutoShop.repository.OrderRepository;
import com.AutoShop.utils.GeneratePdfReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(Long id) { return orderRepository.findById(id);}

    @Override
    public ResponseEntity<InputStreamResource> ordersReportMethod(Long orderId) {

        Optional<Order> order = findOrderById(orderId);
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
