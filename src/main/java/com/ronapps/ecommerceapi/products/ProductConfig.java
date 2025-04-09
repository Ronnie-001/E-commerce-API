package com.ronapps.ecommerceapi.products;

@Configuration
public class ProductConfig {
    
    @Bean
    ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
