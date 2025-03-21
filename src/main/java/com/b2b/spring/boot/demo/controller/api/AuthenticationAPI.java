package com.b2b.spring.boot.demo.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api/auth")
public interface AuthenticationAPI {

  /**
   * Authenticates a user based on the provided username and password.
   *
   * @param username the username of the user attempting to log in
   * @param password the password of the user attempting to log in
   * @return a string indicating the token in case of successful login
   */
  @GetMapping("/login")
  @PreAuthorize("hasRole('ADMIN','USER')")
  String login(@RequestParam String username, @RequestParam String password);

  @GetMapping("/endpointAdmin")
  @PreAuthorize("hasROle('ADMIN')")
  public default ResponseEntity<String> accessoAdmin()
  {
    return  ResponseEntity.ok("Accesso consentito: utente ADMIN");
  }

  @GetMapping("/endpointUser")
  @PreAuthorize("hasROle('USER')")
  public default ResponseEntity<String> accessoUser()
  {
    return  ResponseEntity.ok("Accesso consentito: utente USER");
  }

}
