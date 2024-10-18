package org.example.orderservice.utils;


import org.example.orderservice.dto.OrderDTO;
import org.example.orderservice.dto.ProductDTO;
import org.example.orderservice.model.Order;

import java.time.LocalDate;

public class DTOMapper {


public static OrderDTO convertToDto(Order order, ProductDTO productDTO) {
    OrderDTO orderDTO = new OrderDTO();
    orderDTO.setId(order.getId());
    orderDTO.setOrderNumber(order.getOrderNumber());
    orderDTO.setFormattedOrderDate(order.getOrderDate().toString());
    orderDTO.setProductId(order.getProductId());
    orderDTO.setProductDTO(productDTO);
    return orderDTO;

}


public static Order convertToDo(OrderDTO orderDTO){
    Order order = new Order();
    order.setId(orderDTO.getId());
    order.setOrderNumber(orderDTO.getOrderNumber());
    order.setOrderDate(LocalDate.parse(orderDTO.getFormattedOrderDate()));
    return order;
}

}


