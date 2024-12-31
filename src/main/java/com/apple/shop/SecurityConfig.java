package com.apple.shop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //어떤 페이지를 검사할지 설정
        http.csrf((csrf)->csrf.disable()); //csrf보안 끄기, 다른사이트에서 내 사이트에 api요청하는걸 방지하는 보안 기능
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll() //해당 url에 로그인 없이 접속 허용
        );
        return http.build();
    }
}