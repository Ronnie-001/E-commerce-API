package com.ronapps.ecommerceapi.shoppingcart;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "SHOPPING CARTS")
public class ShoppingCart {

    @Id
    private String user;

    @ElementCollection
    private List<String> cart;



}
