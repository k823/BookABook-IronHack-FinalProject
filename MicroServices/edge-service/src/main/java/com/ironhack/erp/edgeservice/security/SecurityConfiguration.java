package com.ironhack.erp.edgeservice.security;

import com.ironhack.erp.edgeservice.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.NullRequestCache;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserDetailsServiceImpl userDetailsService;
  
  @Bean
  public PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder);
  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.httpBasic();

    httpSecurity.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests().antMatchers("/h2-console/**").permitAll();
    httpSecurity.headers().frameOptions().disable();

    httpSecurity.authorizeRequests()
            .antMatchers("**").permitAll()
    .and().requestCache().requestCache(new NullRequestCache()).and().httpBasic().and().cors().and().csrf().disable();;

  }
}
