package com.ronapps.ecommerceapi.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
