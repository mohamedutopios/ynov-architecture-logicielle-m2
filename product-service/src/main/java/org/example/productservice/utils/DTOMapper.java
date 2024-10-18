package org.example.productservice.utils;


import org.example.productservice.dto.ProductDTO;
import org.example.productservice.model.Product;

import java.time.LocalDate;

public class DTOMapper {


public static ProductDTO convertToDto(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setPrice(product.getPrice());
    return productDTO;
}

public static Product convertToDo(ProductDTO productDTO){
    Product product = new Product();
    product.setId(productDTO.getId());
    product.setName(productDTO.getName());
    product.setPrice(productDTO.getPrice());
    return product;
}




}


