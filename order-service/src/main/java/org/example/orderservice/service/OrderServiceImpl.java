package org.example.orderservice.service;


import org.example.orderservice.client.RestClient;
import org.example.orderservice.dto.OrderDTO;
import org.example.orderservice.dto.ProductDTO;
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

    @Autowired
    private RestClient restClient;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.
                findAll()
                .stream()
                .map(order -> {
                    ProductDTO productDTO = restClient.getProduct(order.getProductId());
                    return DTOMapper.convertToDto(order, productDTO);
                })
                .toList();
    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO) {
        ProductDTO productDTO = restClient.getProduct(orderDTO.getProductId());
        if(productDTO == null) {
            throw new ResourceNotFoundException("Product not found");
        }
        Order order = DTOMapper.convertToDo(orderDTO);
        order.setProductId(productDTO.getId());
        return DTOMapper.convertToDto(orderRepository.save(order), productDTO);
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
        ProductDTO productDTO = restClient.getProduct(order.getProductId());
        return DTOMapper.convertToDto(order, productDTO);
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

        ProductDTO productDTO = restClient.getProduct(order.getProductId());

        if(productDTO == null) {
            throw new ResourceNotFoundException("Product not found");
        }
        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setOrderDate(LocalDate.parse(orderDTO.getFormattedOrderDate()));
        order.setProductId(productDTO.getId());
        return DTOMapper.convertToDto(orderRepository.save(order), productDTO);
    }
}
