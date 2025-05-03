package com.parsa.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                // http.formLogin(Customizer.withDefaults());
                // enable login from outside the spring login form
                .httpBasic(Customizer.withDefaults()).
                // stateless http
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean

    public UserDetailsService userDetailsService() {

        UserDetails user1 = User.withDefaultPasswordEncoder().username("Venom").password("password").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("Kaz").password("password").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
