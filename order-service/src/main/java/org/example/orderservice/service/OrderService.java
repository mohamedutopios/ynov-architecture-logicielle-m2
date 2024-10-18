package org.example.orderservice.service;



import org.example.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();
    OrderDTO saveOrder(OrderDTO order);
    OrderDTO getOrderById(Long id);
    void deleteOrder(Long id);
    OrderDTO updateOrder(Long id,OrderDTO order);



}
