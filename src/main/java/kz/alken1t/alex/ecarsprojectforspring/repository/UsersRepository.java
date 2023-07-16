package kz.alken1t.alex.ecarsprojectforspring.repository;

import kz.alken1t.alex.ecarsprojectforspring.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository  extends JpaRepository<Users,Long> {

   Optional<Users> findByEmail(String email);

}