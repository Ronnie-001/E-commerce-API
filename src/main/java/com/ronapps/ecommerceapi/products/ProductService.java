package com.ronapps.ecommerceapi.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    } 
    
    public void addNewProduct(Product productToAdd) {
        productRepository.save(productToAdd);        
    }
}
