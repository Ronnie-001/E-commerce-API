package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    private final UserService userService;
    private final SecurityContextRepository securityContextRepository = new HttpSessionSecurityContextRepository();
    private final AuthenticationManager authenticationManager;
    private final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

    @Autowired
    public UserController(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/home")
    public String greeting() {
        return "User needs to create a user first to purchase products";
    }
    
    @PostMapping("/register_user")
    public UserDTO createUser(@RequestBody UserDTO userDto) {
        userService.registerNewUser(userDto);
        return userDto;
    }

    @PostMapping("/register_admin")
    public UserDTO createAdmin(@RequestBody UserDTO userDto) {
        userService.registerNewAdmin(userDto);
        return userDto;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginCredentials loginCredentials, HttpServletRequest request, HttpServletResponse response) {  
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken
        .unauthenticated(loginCredentials.getUsername(), loginCredentials.getPassword());
        
        Authentication authentication = authenticationManager.authenticate(token);    
        SecurityContext context = securityContextHolderStrategy.createEmptyContext();
        context.setAuthentication(authentication);
        securityContextHolderStrategy.setContext(context);
        securityContextRepository.saveContext(context, request, response);

        return "Login of user" + authentication.getPrincipal().toString() + "was successfull!";
    }

    @PostMapping("/logout")
    public void logout() {
    }
    
    @GetMapping("/logout_success")
    public String logoutSuccess() {
        return "Logout of user" + "..." + "was successfull!";  
    } 
}

class LoginCredentials {

    private String username;
    private String password;

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
