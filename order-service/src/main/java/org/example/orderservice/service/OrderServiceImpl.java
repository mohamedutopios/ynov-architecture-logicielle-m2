package org.example.orderservice.service;


import org.example.orderservice.dto.OrderDTO;
import org.example.orderservice.exception.ResourceNotFoundException;
import org.example.orderservice.model.Order;
import org.example.orderservice.repository.OrderRepository;
import org.example.orderservice.utils.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.
                findAll()
                .stream()
                .map(DTOMapper::convertToDto)
                .toList();
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        Product product = DTOMapper.convertToDo(productService.getProductById(orderDTO.getProductId()));
        Order order = DTOMapper.convertToDo(orderDTO,product);
        return DTOMapper.convertToDto(orderRepository.save(order));
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        orderRepository.delete(order);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return DTOMapper.convertToDto(order);
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setOrderDate(LocalDate.parse(orderDTO.getFormattedOrderDate()));

        Product product = DTOMapper.convertToDo(productService.getProductById(orderDTO.getProductId()));
        order.setProduct(product);

        return DTOMapper.convertToDto(orderRepository.save(order));
    }
}
