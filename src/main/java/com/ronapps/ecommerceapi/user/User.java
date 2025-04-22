package com.ronapps.ecommerceapi.user;

import jakarta.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ronapps.ecommerceapi.products.Product;
import com.ronapps.ecommerceapi.shoppingcart.Cart;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(schema = "users")
public class User implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false,  unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cascade({CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_roles",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "cart_id")
    private Cart cart = null; 

    public User() {}

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void addRole(Role newRole) {
        this.roles.add(newRole);
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return this.roles.stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName())).collect(Collectors.toSet());
    }
    
    public void setCart(Cart newCart) {
        this.cart = newCart; 
    }

    public Cart getCart() {
       return this.cart; 
    }

    public void addToCart(Product product) {
        this.cart.addProductToCart(product);
    } 

    public void removeFromCart(Product product) {
        this.cart.removeProductFromCart(product);
    } 

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
