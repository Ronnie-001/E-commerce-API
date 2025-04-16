package com.ronapps.ecommerceapi.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class ShoppingCartController {

    //Get the currently authenticated user
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    private final ShoppingCartService shoppingCartService;
    
    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/user/cart/add-to-cart/{idOfItem}")
    public String addToUserCart(@PathVariable long idOfItem) {
        shoppingCartService.addToUserCart(authentication.getName(), idOfItem); 
        return "Item added to cart";
    }

    @PostMapping("/user/cart/remove-from-cart/{id}")
    public String deleteFromUserCart(@PathVariable long idOfItem) {
        shoppingCartService.removeFromUserCart(authentication.getName(), idOfItem);
        return "Item removed from cart";
    }
}
