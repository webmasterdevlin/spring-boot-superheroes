package com.example.superheroes.jwt.services;

import java.util.ArrayList;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String s)
    throws UsernameNotFoundException {
    return new User("username", "password", new ArrayList<>());
  }
}
