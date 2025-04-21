package com.ronapps.ecommerceapi.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(schema = "users")
public class Role {
    
    //TODO: Fix this, role id in PostgreSQL database should not increment for each user.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    public void setRole(String newRoleName) {
        this.roleName = newRoleName;
    }

    public String getRoleName() {
        return this.roleName;
    }
}
