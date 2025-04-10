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

    public void deleteProduct(Product productToDelete) {
        productRepository.delete(productToDelete);
    }

    public void updateProdcutName(String newName) {
        Product product = productRepository.findByProductName(productToUpdate.getProductName());
        product.setProductName(newName);
    }

    public void getProduct() {
        
    }
}
