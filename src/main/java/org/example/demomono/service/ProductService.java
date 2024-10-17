package org.example.demomono.service;

import org.example.demomono.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Long id);

}
