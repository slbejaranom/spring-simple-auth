package practice.security.springlogin.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import practice.security.springlogin.repository.UserRepository;
import practice.security.springlogin.entity.RegisteredUser;
import practice.security.springlogin.security.UserPrincipal;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<RegisteredUser> user = userRepository.findById(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("Username was not found");
    }
    return new UserPrincipal(user.get());
  }
}
