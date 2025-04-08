package com.ronapps.ecommerceapi.products;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    

    @PostMapping("/admin/add_product")
    public String addProduct() {
        return "";
    }

}
