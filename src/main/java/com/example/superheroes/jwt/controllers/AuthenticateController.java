package com.example.superheroes.jwt.controllers;

import com.example.superheroes.jwt.models.AuthenticationRequest;
import com.example.superheroes.jwt.models.AuthenticationResponse;
import com.example.superheroes.jwt.services.ApplicationUserDetailsService;
import com.example.superheroes.jwt.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
class AuthenticateController {

  private final AuthenticationManager authenticationManager;
  private final JwtUtil jwtTokenUtil;
  private final ApplicationUserDetailsService userDetailsService;

  @RequestMapping(value = "/authenticate")
  @ResponseStatus(HttpStatus.CREATED)
  public AuthenticationResponse createAuthenticationToken(
    @RequestBody AuthenticationRequest authenticationRequest
  ) throws Exception {
    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          authenticationRequest.getUsername(),
          authenticationRequest.getPassword()
        )
      );
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password", e);
    }

    var userDetails = userDetailsService.loadUserByUsername(
      authenticationRequest.getUsername()
    );
    System.out.println(userDetails);
    var jwt = jwtTokenUtil.generateToken(userDetails);

    return new AuthenticationResponse(jwt);
  }
}