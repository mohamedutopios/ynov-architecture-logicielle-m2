package org.example.demomono.controller;


import org.example.demomono.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }






}
