package com.ronapps.ecommerceapi.payment;

import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}   
