package com.ronapps.ecommerceapi.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "USER")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;
    
    private String email;

    public String setEmail() {
        return this.email;
    }

    public void getEmail(String email) {
        this.email = email;
    }
}
