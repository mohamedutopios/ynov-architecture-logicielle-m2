package org.example.demomono.controller;

import org.example.demomono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/products")
public class ProductController {


    @Autowired
    private ProductService productService;




}
