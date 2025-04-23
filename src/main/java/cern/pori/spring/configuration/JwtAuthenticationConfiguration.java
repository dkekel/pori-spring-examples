package cern.pori.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * JWT Authentication Configuration for the Spring Boot application.
 * Configures the authentication components needed for JWT-based authentication.
 */
@Configuration
public class JwtAuthenticationConfiguration {

  /**
   * Password encoder for secure password storage
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Authentication manager for processing authentication requests
   */
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
      throws Exception {
    return config.getAuthenticationManager();
  }

  /**
   * In-memory user details service for testing and development
   * Spring Boot will automatically use this UserDetailsService bean for authentication
   */
  @Bean
  public UserDetailsService userDetailsService() {
    PasswordEncoder encoder = passwordEncoder();

    // Create an admin user
    UserDetails adminUser = User.builder()
        .username("admin")
        .password(encoder.encode("admin123"))
        .roles("ADMIN")
        .build();

    // Create a regular user
    UserDetails regularUser = User.builder()
        .username("user")
        .password(encoder.encode("user123"))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(adminUser, regularUser);
  }

}
