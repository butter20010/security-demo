package spring.security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagerConfiguration {

  @Bean
  public UserDetailsService userDetailsService() {

    InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager(); //only for testing
    UserDetails user = User.withUsername("user").password("user").build();
    userDetailsService.createUser(user);
    return userDetailsService;
  }

  @Bean
  @SuppressWarnings("deprecation")
  public PasswordEncoder passwordEncoder() {

    return NoOpPasswordEncoder.getInstance(); //only for testing
  }
}
