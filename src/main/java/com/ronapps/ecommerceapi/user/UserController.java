package com.ronapps.ecommerceapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    
    @PostMapping("/api/v1/register-user")
    public UserDTO createUser(@RequestBody UserDTO userDto) {
        userService.registerNewUser(userDto);
        return userDto;
    }

    @PostMapping("/api/v1/register-admin")
    public UserDTO createAdmin(@RequestBody UserDTO userDto) {
        userService.registerNewAdmin(userDto);
        return userDto;
    }
    
    @PostMapping("/api/v1/login")
    public String login(@RequestBody LoginCredentials loginCredentials, HttpServletRequest request, HttpServletResponse response) {  
        UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken
        .unauthenticated(loginCredentials.getUsername().toString(), loginCredentials.getPassword().toString());

        Authentication authentication = authenticationManager.authenticate(token);

        if (authentication.isAuthenticated()) {
            SecurityContext context = securityContextHolderStrategy.createEmptyContext();
            context.setAuthentication(authentication);
            securityContextHolderStrategy.setContext(context);
            securityContextRepository.saveContext(context, request, response);
        } else {
            throw new BadCredentialsException("Invalid credintials entered.");
        }
        return "Login of user: " + authentication.getName() + " was successfull! " + " session id: " + request.getSession().getId();
    }

    @GetMapping("/user/test")
    public String userRBAC() {
        return "User only endpoint";
    }

    @GetMapping("/api/v1/logout-success")
    public String logoutSuccess() {
        return "Logout was successfull!";  
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
