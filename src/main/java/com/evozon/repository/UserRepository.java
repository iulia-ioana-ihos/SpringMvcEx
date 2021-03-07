package com.evozon.repository;

import com.evozon.entity.User;

import java.util.List;

public interface UserRepository {

    public void saveUser(User user);

    public List<User> findAll();

    public User findByUsername(String username);
}
