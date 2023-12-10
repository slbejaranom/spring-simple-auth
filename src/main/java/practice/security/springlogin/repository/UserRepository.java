package practice.security.springlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.security.springlogin.entity.RegisteredUser;

public interface UserRepository extends JpaRepository<RegisteredUser, String> {

}