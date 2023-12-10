package practice.security.springlogin.controller;

import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.security.springlogin.dto.login.LoginRequest;
import practice.security.springlogin.dto.login.LoginResponse;

@RestController
@RequestMapping("/login-request")
@RequiredArgsConstructor
public class LoginController {

  private final AuthenticationManager authenticationManager;
  private final PasswordEncoder passwordEncoder;

  @PostMapping
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    String encodedPassword = passwordEncoder.encode(loginRequest.getPassword());
    Authentication authenticationRequest = UsernamePasswordAuthenticationToken.unauthenticated(
        loginRequest.getUsername(), loginRequest.getPassword());
    Authentication authenticationResponse = authenticationManager.authenticate(authenticationRequest);
    return LoginResponse.builder()
        .timeOfLogin(new Date())
        .logginMessage("Bienvenido")
        .build();
  }
}
