package com.ronapps.ecommerceapi.products;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
   
    private final ProductService productService; 
        
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/add_product")
    public String addProduct(@PathVariable Product product) {
        productService.addNewProduct(product);
        return "Product added to database!";
    }
    
    @PatchMapping("/admin/update_product")
    public String updateProduct(@PathVariable Product product) {
        return "";
    } 

    @DeleteMapping("/admin/update_product")
    public String deleteProdcut(@PathVariable Product product) {
        return "";
    }
    
    @GetMapping("/admin/get_product")
    public String getProdcut(@PathVariable Product product) {
        return "";
    }
}
