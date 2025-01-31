package com.escod.kepler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.authorization.web.OAuth2TokenRevocationEndpointFilter;

@Configuration
@EnableWebSecurity
public class AuthorizationServerConfig {

  @Bean
  public OAuth2TokenRevocationEndpointFilter tokenRevocationEndpointFilter(
      AuthenticationManager authenticationManager) {

    return new OAuth2TokenRevocationEndpointFilter(authenticationManager);
  }

}
