package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.models.UserEntity;
import com.pokemonreview.api.repository.UserRepository;
import com.pokemonreview.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
