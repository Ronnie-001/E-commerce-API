package com.ronapps.ecommerceapi.payment;

import com.stripe.*;
import com.stripe.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.ronapps.ecommerceapi.user.UserRepository;

public class Payment {
    
    private final UserRepository userRepository;
    
    // Grabbing the Stripe API key.
    @Value("${app.stripe.api.key}")
    private String apiKey;    
    
    @Autowired
    public Payment(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
