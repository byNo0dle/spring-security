package com.ufostyle.security.infrastructure.configs;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class WebSecurityConfig {

  // Esta configuracion nos permite proteger todas las urls que tenemos hasta ahora.
  @Bean
  public SecurityWebFilterChain webFilterChain(ServerHttpSecurity httpSecurity) {
    httpSecurity.authorizeExchange((exchange) -> {
      exchange.matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll();
      exchange.pathMatchers("").authenticated();
    });
    httpSecurity.formLogin(Customizer.withDefaults());
    return httpSecurity.build();
  }
}
