package com.ronapps.ecommerceapi.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean
    UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}
