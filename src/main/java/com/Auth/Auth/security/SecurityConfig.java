package com.Auth.Auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // Désactivation de CSRF pour notre API REST
                .csrf(csrf -> csrf.disable())

                // Pas de formulaire de connexion HTML
                .formLogin(form -> form.disable())

                // Pas d'authentification HTTP Basic
                .httpBasic(basic -> basic.disable());

        return http.build();
    }
}