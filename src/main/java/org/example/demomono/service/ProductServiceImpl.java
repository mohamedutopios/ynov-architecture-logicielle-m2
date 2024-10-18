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
    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = DTOMapper.convertToDo(productDTO);
       return DTOMapper.convertToDto(productRepository.save(product));

    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product1 = productRepository.findById(productDTO.getId()).orElse(null);
        if(product1 != null) {
            product1.setName(productDTO.getName());
            product1.setPrice(productDTO.getPrice());
            return DTOMapper.convertToDto(productRepository.save(product1));
        }

        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(product != null) {
            productRepository.delete(product);
        }
    }
}
