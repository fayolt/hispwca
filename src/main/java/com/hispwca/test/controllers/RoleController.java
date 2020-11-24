package com.hispwca.test.controllers;

import java.util.List;

import com.hispwca.test.models.Role;
import com.hispwca.test.repositories.RoleRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
  @Autowired
  private RoleRepository roleRepository;

  @GetMapping
  public List<Role> list(){
    return roleRepository.findAll();
  }

  @GetMapping("{id}")
  public Role get(@PathVariable Long id){
    return roleRepository.getOne(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Role create(@RequestBody final Role role) {
    return roleRepository.saveAndFlush(role);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    roleRepository.deleteById(id);
  }

  @PutMapping("{id}")
  public Role update(@PathVariable Long id, @RequestBody Role role){
    Role existingRole = roleRepository.getOne(id);
    BeanUtils.copyProperties(role, existingRole, "role_id");
    return roleRepository.saveAndFlush(existingRole);
  }
}
