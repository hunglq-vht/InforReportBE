package com.information.api.service.impl;

import com.information.api.models.Role;
import com.information.api.models.UserEntity;
import com.information.api.repository.RoleRepository;
import com.information.api.repository.UserRepository;
import com.information.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    @Override
    public boolean deleteUser(int userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isEmpty()) return false;
        List<Role> currentRoles = new ArrayList<>(user.get().getRoles());
        for (Role role : currentRoles) {
            user.get().getRoles().remove(role);
        }
        userRepository.delete(user.get());
//        boolean isUserExist = userRepository.existsById(userId);
//        if (isUserExist) {
//            userRepository.deleteById(userId);
//            return true;
//        }
        return true;
    }
}
