package com.b2b.spring.boot.demo.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final AuthorizationHeaderFilter authorizationHeaderFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .cors(AbstractHttpConfigurer::disable)
        .httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults())
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(authorizationHeaderFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(
            authReq -> authReq
                    .requestMatchers(HttpMethod.GET, "/api/auth/login").permitAll()
                    //.requestMatchers(HttpMethod.GET, "/api/auth/endpointAdmin").hasRole("ADMIN")
                    //.requestMatchers(HttpMethod.GET, "/api/auth/endpointUser").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/users/list").permitAll()
                    .requestMatchers(HttpMethod.POST, "/users/nuovo").permitAll()
                    .requestMatchers(HttpMethod.PUT, "/users/{id}").permitAll()
                    .requestMatchers(HttpMethod.DELETE, "/users/{id}").permitAll()

                .anyRequest().authenticated());
    return httpSecurity.build();
  }

}
