package practice.security.springlogin.security;

import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import practice.security.springlogin.entity.RegisteredUser;

@RequiredArgsConstructor
public class UserPrincipal implements UserDetails {

  private final RegisteredUser registeredUser;
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return registeredUser.getPassword();
  }

  @Override
  public String getUsername() {
    return registeredUser.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
