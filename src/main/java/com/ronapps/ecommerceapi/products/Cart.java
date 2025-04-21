package com.ronapps.ecommerceapi.products;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Set<Product> itemsInCart = new HashSet<>();

    public void addProductToCart(Product productToAdd) {
        itemsInCart.add(productToAdd);
    }
    
    public void removeProductFromCart(Product productToRemove) {
        itemsInCart.remove(productToRemove);
    }
}
