package com.ronapps.ecommerceapi.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;

import com.ronapps.ecommerceapi.products.Product;
import com.ronapps.ecommerceapi.products.ProductRepository;
import com.ronapps.ecommerceapi.user.User;
import com.ronapps.ecommerceapi.user.UserRepository;

public class ShoppingCartService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public void addToUserCart(String username, long idOfItem) {
        User user = userRepository.findByUsername(username);
        Product productToAdd = productRepository.findById(idOfItem).get();
        user.addToCart(productToAdd);
        userRepository.save(user);
    }

    public void removeFromUserCart(String username, long idOfItem) {
        User user = userRepository.findByUsername(username);
        Product productToRemove = productRepository.findById(idOfItem).get();
        user.removeFromCart(productToRemove);
        userRepository.save(user);
    }
}
