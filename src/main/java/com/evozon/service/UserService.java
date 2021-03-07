package com.evozon.service;

import com.evozon.mvc.model.UserDTO;

import java.util.List;

public interface UserService {

    public void saveUser(UserDTO user);

    public List<UserDTO> findAll();

    public UserDTO findByUsername(String username);
}
