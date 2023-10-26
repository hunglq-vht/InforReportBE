package com.information.api.service.impl;

import com.information.api.models.UserEntity;
import com.information.api.repository.UserRepository;
import com.information.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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

    @Override
    public UserEntity updateUser(UserEntity newUserInfo) {
        log.info(newUserInfo.toString());
        return userRepository.save(newUserInfo);
    }
}
