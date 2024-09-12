package com.myCompany.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf)-> csrf.disable()); //csrf : 다른 사이트에서 접속하는 csrf공격 방지
        http.authorizeHttpRequests((authorize) ->
                //authorize.requestMatchers("/**").permitAll()
                authorize.requestMatchers("/**").permitAll()

        );
        return http.build();
    }
}