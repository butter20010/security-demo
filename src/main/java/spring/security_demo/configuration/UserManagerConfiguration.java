package spring.security_demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import spring.security_demo.configuration.user_details_service.InMemoryUserDetailsService;
import spring.security_demo.configuration.user_details_service.User;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class UserManagerConfiguration {

  @Bean
  public UserDetailsService userDetailsService(DataSource dataSource) {

    return new JdbcUserDetailsManager(dataSource);
  }

  @Bean
  @SuppressWarnings("deprecation")
  public PasswordEncoder passwordEncoder() {

    return NoOpPasswordEncoder.getInstance(); //only for testing
  }
}
