package com.hispwca.test.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private Long roleId;
    
    private String name;

    @ManyToMany(mappedBy = "roles")
    //   @JsonIgnore
    private List<User> users;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
        roleId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
