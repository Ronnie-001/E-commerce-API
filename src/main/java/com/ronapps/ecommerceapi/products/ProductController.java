package com.ronapps.ecommerceapi.products;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
   
    private final ProductService productService; 
        
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/admin/add_product")
    public String addProducttoDb(@PathVariable Product product) {
        productService.addNewProduct(product);
        return "Product added to database!";
    } 
    
    //TODO: Add some sort of class to make a @PathVariable and pass as parameters.
    @PutMapping("admin/update_product/update_name")
    public String updateProductNameInDb(String productName) {
        productService.updateProdcutName(productName);
        return "Updated product name in database!";
    } 

    @PutMapping("admin/update_product/update_price")
    public String updateProductPriceInDb(@PathVariable Product product) {
        return "";
    }

    @DeleteMapping("admin/delete_product")
    public String deleteProdcutInDb(@PathVariable Product product) {
        productService.deleteProduct(product);
        return "Deleted product in database!";
    }
    
    @GetMapping("/admin/get_product")
    public String getProdcutInDb(@PathVariable Product product) {
        return "";
    }
}
