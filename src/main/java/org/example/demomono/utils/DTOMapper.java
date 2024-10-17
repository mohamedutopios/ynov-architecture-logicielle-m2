package org.example.demomono.utils;


import org.example.demomono.dto.ProductDTO;
import org.example.demomono.model.Product;

public class DTOMapper {


public static ProductDTO convertToDto(Product product) {
    ProductDTO productDTO = new ProductDTO();
    productDTO.setId(product.getId());
    productDTO.setName(product.getName());
    productDTO.setPrice(product.getPrice());
    return productDTO;
}




}
