package com.ronapps.ecommerceapi.products;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {
    
    @Bean
    ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
