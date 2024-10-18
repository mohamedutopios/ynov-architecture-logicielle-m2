package org.example.orderservice.client;


import org.example.orderservice.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {


    @Autowired
    private RestTemplate restTemplate;

    private String productServiceUrl = "http://localhost:8081/api/products/";


    public ProductDTO getProduct(Long productId) {

        return restTemplate.getForObject(productServiceUrl + productId, ProductDTO.class);

    }


}
