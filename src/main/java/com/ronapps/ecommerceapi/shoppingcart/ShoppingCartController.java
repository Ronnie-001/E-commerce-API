package com.ronapps.ecommerceapi.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;
 
    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/api/v1/user/cart/add-to-cart/{id}")
    public String addToUserCart(@PathVariable long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        shoppingCartService.addToUserCart(authentication.getName(), id); 
        return "Item added to cart";
    }
    
    @DeleteMapping("/user/cart/remove-from-cart/{id}")
    public String deleteFromUserCart(@PathVariable long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        shoppingCartService.removeFromUserCart(authentication.getName(), id);
        return "Item removed from cart";
    }
}
