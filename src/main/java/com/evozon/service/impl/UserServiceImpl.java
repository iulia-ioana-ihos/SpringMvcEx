package com.evozon.service.impl;

import com.evozon.converter.user.UserDtoToUserConverter;
import com.evozon.converter.user.UserToUserDtoConverter;
import com.evozon.entity.User;
import com.evozon.mvc.model.UserDTO;
import com.evozon.repository.UserRepository;
import com.evozon.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    private UserDtoToUserConverter dtoToEntity;

    private UserToUserDtoConverter entityToDto;

    private UserRepository userRepository;

    @Override
    public void saveUser(UserDTO userDto) {
        User user = dtoToEntity.convert(userDto);
        System.out.println(userDto);
        userRepository.saveUser(user);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> users = new ArrayList<>();
        return userRepository.findAll().stream().map(entityToDto::convert).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUsername(String username) {
        return entityToDto.convert(userRepository.findByUsername(username));
    }


    public void setDtoToEntity(UserDtoToUserConverter dtoToEntity) {
        this.dtoToEntity = dtoToEntity;
    }

    public void setEntityToDto(UserToUserDtoConverter entityToDto) {
        this.entityToDto = entityToDto;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
