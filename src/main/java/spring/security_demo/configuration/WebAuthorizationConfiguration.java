package spring.security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import spring.security_demo.configuration.filters.AuthenticationLoggingFilter;
import spring.security_demo.configuration.filters.RequestValidationFilter;

@Configuration
public class WebAuthorizationConfiguration {

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {

    http.httpBasic(Customizer.withDefaults());
    http.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
            .addFilterAfter(new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
            .authorizeHttpRequests(req -> req.anyRequest().authenticated());
    return http.build();
  }
}
