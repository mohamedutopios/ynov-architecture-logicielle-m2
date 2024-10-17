package org.example.demomono.service;

import org.example.demomono.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        return null;
    }

    @Override
    public void deleteOrderById(Long id) {

    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return null;
    }
}
