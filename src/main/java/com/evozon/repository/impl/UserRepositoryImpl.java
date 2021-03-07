package com.evozon.repository.impl;

import com.evozon.entity.User;
import com.evozon.repository.UserRepository;
import com.evozon.repository.UserStoreUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public void saveUser(User user) {
        UserStoreUtil.writeUser(user);
    }

    @Override
    public List<User> findAll() {
        return UserStoreUtil.readAll();
    }

    @Override
    public User findByUsername(String username) {

        List<User> users = UserStoreUtil.readAll();
        for(User user : users) {
            if(user.getUsername().equals(username))
                return user;
        }

        return new User();

    }
}
