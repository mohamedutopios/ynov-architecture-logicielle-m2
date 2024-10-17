package org.example.demomono.service;

import org.example.demomono.dto.ProductDTO;
import org.example.demomono.model.Product;
import org.example.demomono.repository.ProductRepository;
import org.example.demomono.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(DTOMapper::convertToDto)
                .toList();
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null) {
            return DTOMapper.convertToDto(product);
        }else{
            return null;
        }

    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
