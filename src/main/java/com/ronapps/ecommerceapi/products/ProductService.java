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

    public void deleteProduct(String productToDelete) {
        Product product = productRepository.findByProductName(productToDelete);
        productRepository.delete(product);
    }

    public void updateProductName(String productToUpdate, String newName) {
        Product product = productRepository.findByProductName(productToUpdate);
        product.setProductName(newName);
        productRepository.save(product);
    }

    public void updateProductPrice(String productToUpdate, double newPrice) {
        Product product = productRepository.findByProductName(productToUpdate);
        product.setPrice(newPrice);
        productRepository.save(product);
    }

    public Product getProduct(String productName) {
        Product product = productRepository.findByProductName(productName);        
        return product;
    }
}
