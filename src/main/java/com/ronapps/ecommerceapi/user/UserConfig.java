package com.ronapps.ecommerceapi.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    UserService userService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return new UserService(userRepository, bCryptPasswordEncoder);
    }

    @Bean
    MyUserDetailsService myUserDetailsService(UserRepository userRepository) {
        return new MyUserDetailsService(userRepository);
    }
}
