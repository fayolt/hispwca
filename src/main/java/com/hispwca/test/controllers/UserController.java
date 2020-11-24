package com.hispwca.test.controllers;

import java.util.List;

import com.hispwca.test.models.User;
import com.hispwca.test.repositories.UserRepository;

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
@RequestMapping("/api/v1/users")
public class UserController {
  
  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> list(){
    return userRepository.findAll();
  }

  @GetMapping("{id}")
  public User get(@PathVariable Long id){
    return userRepository.getOne(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody final User user) {
    return userRepository.saveAndFlush(user);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    userRepository.deleteById(id);
  }

  @PutMapping("{id}")
  public User update(@PathVariable Long id, @RequestBody User user){
    User existingUser = userRepository.getOne(id);
    BeanUtils.copyProperties(user, existingUser, "user_id");
    return userRepository.saveAndFlush(existingUser);
  }
}
