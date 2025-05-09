package com.ronapps.ecommerceapi.products;

import com.ronapps.ecommerceapi.shoppingcart.Cart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "storefront")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price", nullable = false)
    private double productPrice;

    @Column(name = "category", nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;  //Owning side between the product and the cart.

    public void setProductName(String newName) {
        this.productName = newName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setPrice(double newPrice) {
        this.productPrice = newPrice;
    }

    public double getProductPrice() {
        return this.productPrice;
    }
 
    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public String getCategory() {
        return this.category;
    }
}
