package org.example.demomono.service;

import org.example.demomono.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();
    Order saveOrder(Order order);
    Order getOrderById(Long id);
    void deleteOrderById(Long id);
    Order updateOrder(Long id,Order order);



}
