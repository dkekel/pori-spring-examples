package cern.pori.spring.configuration;

import cern.pori.spring.security.JwtAuthenticationEntryPoint;
import cern.pori.spring.security.filter.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

  private static final String ADMIN_ROLE = "ADMIN";

  private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  public SecurityConfiguration(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
      JwtAuthenticationFilter jwtAuthenticationFilter) {
    this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
  }


  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .headers(headers ->
            headers.frameOptions(FrameOptionsConfig::sameOrigin))
        .csrf(AbstractHttpConfigurer::disable)
        .exceptionHandling(exception ->
            exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(auth ->
            auth
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/public/**").permitAll()
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/api/secure/admin/**").hasRole(ADMIN_ROLE)
                .requestMatchers("/api/secure/user/**").hasAnyRole("USER", ADMIN_ROLE)
                .anyRequest().authenticated());

    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
