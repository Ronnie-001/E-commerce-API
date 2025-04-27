package com.ronapps.ecommerceapi.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private final ProductService productService; 
    
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/v1/admin/add-product")
    public String addProducttoDb(@RequestBody Product product) {
        productService.addNewProduct(product);
        return "Product added to database!";
    } 
    
    @PutMapping("/api/v1/admin/update-product/update-name/{id}")
    public String updateProductNameInDb(@PathVariable long id, @RequestBody ProductNameUpdateDetails productNameUpdateDetails) {
        productService.updateProductName(id, productNameUpdateDetails.getNewName());
        return "Updated product name in database!";
    } 

    @PutMapping("/api/v1/admin/update-product/update-price/{id}")
    public String updateProductPriceInDb(@PathVariable long id, @RequestBody ProductPriceUpdateDetails productPriceUpdateDetails) {
        productService.updateProductPrice(id, productPriceUpdateDetails.getNewPrice());
        return "Updated product price in database!";
    }

    @DeleteMapping("api/v1/admin/delete-product/{id}")
    public String deleteProdcutInDb(@PathVariable long id) {
        productService.deleteProduct(id);
        return "Deleted product in database!";
    }
    
    @GetMapping("/api/v1/admin/get-product/{id}")
    public String getProdcutInDb(@PathVariable long id) {
        Product product = productService.getProduct(id);
        return "Product name: " + product.getProductName() + ", product price: " + product.getProductPrice();
    }
}

class ProductNameUpdateDetails {

    private String newName;
   
    public String getNewName() {
        return this.newName; 
    }
}

class ProductPriceUpdateDetails {

    private double newPrice;
    
    public double getNewPrice() {
        return this.newPrice; 
    }
}
