package spring.security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import spring.security_demo.configuration.user_details_service.InMemoryUserDetailsService;
import spring.security_demo.configuration.user_details_service.User;

import java.util.List;

@Configuration
public class UserManagerConfiguration {

  @Bean
  public UserDetailsService userDetailsService() {

    UserDetails user = new User("user", "user", "read");
    List<UserDetails> users = List.of(user);
    return new InMemoryUserDetailsService(users);
  }

  @Bean
  @SuppressWarnings("deprecation")
  public PasswordEncoder passwordEncoder() {

    return NoOpPasswordEncoder.getInstance(); //only for testing
  }
}
