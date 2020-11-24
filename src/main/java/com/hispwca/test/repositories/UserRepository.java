package com.hispwca.test.repositories;

import java.util.Optional;

import com.hispwca.test.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
  
}
