package com.ronapps.ecommerceapi.shoppingcart;

import com.ronapps.ecommerceapi.products.Product;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy = "cart")
    private Set<Product> itemsInCart = new HashSet<>(); 

    public void addProductToCart(Product productToAdd) {
        itemsInCart.add(productToAdd);
    }
    
    public void removeProductFromCart(Product productToRemove) {
        itemsInCart.remove(productToRemove);
    }
}
