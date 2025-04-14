package com.ronapps.ecommerceapi.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/admin/add-product")
    public String addProducttoDb(@RequestBody Product product) {
        productService.addNewProduct(product);
        return "Product added to database!";
    } 
    
    @PutMapping("/admin/update-product/update-name")
    public String updateProductInDb(@RequestBody ProductNameUpdateDetails productNameUpdateDetails) {
        productService.updateProductName(productNameUpdateDetails.getProductName(), productNameUpdateDetails.getNewName());
        return "Updated product name in database!";
    } 

    @PutMapping("/admin/update-product/update-price")
    public String updateProductPriceInDb(@RequestBody ProductPriceUpdateDetails productPriceUpdateDetails) {
        productService.updateProductPrice(productPriceUpdateDetails.getProductName(), productPriceUpdateDetails.getNewPrice());
        return "Updated product price in database!";
    }

    @DeleteMapping("/admin/delete-product")
    public String deleteProdcutInDb(String productName) {
        productService.deleteProduct(productName);
        return "Deleted product in database!";
    }
    
    @GetMapping("/admin/get-product")
    public String getProdcutInDb(String productName) {
        Product product = productService.getProduct(productName);
        return "Product name: " + product.getProductName() + ", product price: " + product.getProductPrice();
    }
}

class ProductNameUpdateDetails {

    private String productName;
    private String newName;
    
    public String getProductName() {
        return this.productName;    
    }
    
    public String getNewName() {
        return this.newName; 
    }

}

class ProductPriceUpdateDetails {

    private String productName;
    private double newPrice;
    
    public String getProductName() {
        return this.productName;    
    }
    
    public double getNewPrice() {
        return this.newPrice; 
    }
}

