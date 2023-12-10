package practice.security.springlogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class RegisteredUser {

  @Id
  private String username;

  private String password;
  private String name;
  private String lastName;
}
