package org.example.orderservice.dto;

import jakarta.persistence.OneToOne;
import lombok.Data;


import java.time.LocalDate;

@Data
public class OrderDTO {

    private Long id;
    private String orderNumber;
    private String formattedOrderDate;
    private Long productId;
    private ProductDTO productDTO;

}
