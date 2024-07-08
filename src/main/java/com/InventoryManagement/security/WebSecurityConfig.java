package com.InventoryManagement.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.InventoryManagement.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    UserRepository userRepo;
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/home").permitAll()
                .anyRequest().permitAll()
            )
            .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            com.InventoryManagement.models.User user = userRepo.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }

            // Determine the role
            String role = user.isAdmin() ? "ADMIN" : "USER";
            
            System.out.println("Role: " + role);

            // Convert custom User to Spring Security's UserDetails
            return User.builder()
                       .username(user.getUsername())
                       .password(user.getPassword()) // The password is already hashed
                       .roles(role)
                       .build();
        };
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
}
