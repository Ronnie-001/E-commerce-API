package com.ronapps.ecommerceapi.shoppingcart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ronapps.ecommerceapi.products.ProductRepository;
import com.ronapps.ecommerceapi.user.UserRepository;

@Configuration
public class ShoppingCartConfig {
    
    @Bean
    ShoppingCartService shoppingCartService(UserRepository userRepository, ProductRepository productRepository) {
        return new ShoppingCartService(userRepository, productRepository);
    }   
}
