package com.ronapps.ecommerceapi.user;

import lombok.ToString;

@ToString
public class UserDTO {

    private String username;

    private String password;


    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }


    public void setUsername(String newUser) {
        this.username = newUser;
    }

    public void setPassword(String newPass) {
        this.password = newPass;
    }

}
