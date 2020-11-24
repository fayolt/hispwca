package com.hispwca.test.repositories;

import com.hispwca.test.models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
  
}
