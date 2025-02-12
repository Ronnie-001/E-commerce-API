package com.ronapps.ecommerceapi.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.HashSet;

@Entity
@Table(schema = "customers")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME", nullable = false,  unique = true)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "USER_ROLES", nullable = false)
    @ElementCollection
    private HashSet<String> roles;

    public User() {}

    public void addRole(String newRole) {
        this.roles.add(newRole);
    }
}
