package com.information.api.service;

import com.information.api.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity updateUser(UserEntity userInfo);

    boolean deleteUser(int userId);
}
