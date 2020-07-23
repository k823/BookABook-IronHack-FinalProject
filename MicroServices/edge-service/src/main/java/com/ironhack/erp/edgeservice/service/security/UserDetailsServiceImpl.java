package com.ironhack.erp.edgeservice.service.security;

import com.ironhack.erp.edgeservice.model.security.User;
import com.ironhack.erp.edgeservice.repository.UserRepository;
import com.ironhack.erp.edgeservice.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    User user = userRepository.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("Invalid username/password combination.");
    return new CustomSecurityUser(user);
  }
  
}
