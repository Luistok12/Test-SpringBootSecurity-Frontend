// package com.springsecurity.springsecurity.config;

// import java.net.http.HttpRequest;

// import org.springframework.context.annotation.Configuration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

// protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
// return http
// .authorizeRequests()
// .requestMatchers("/api/v1/users", "/api/v1/categories").permitAll()
// .anyRequest().authenticated()
// .and()
// .formLogin()
// .loginPage("/api/v1/login")
// .and()
// .build();

// }
// }
