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

    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public void updateProductName(long id, String newName) {
        Product product = productRepository.findById(id).get();
        product.setProductName(newName);
        productRepository.save(product);
    } 

    public void updateProductPrice(long id, double newPrice) {
        Product product = productRepository.findById(id).get();
        product.setPrice(newPrice);
        productRepository.save(product);
    }

    public Product getProduct(long id) {
        Product product = productRepository.findById(id).get();
        return product;
    }
}
