package com.example.buoi1.repo;

import com.example.buoi1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);

    Boolean existsByEmail(String email);
    boolean existsByUsernameOrEmail(String username, String email);
}
