package com.ronapps.ecommerceapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> request
                        .requestMatchers("/user/login/**")
                        .hasRole("ROLE_USER"))
                        .httpBasic(Customizer.withDefaults())
                        .csrf(crsf -> crsf.disable());
        return http.build();
    }
}
