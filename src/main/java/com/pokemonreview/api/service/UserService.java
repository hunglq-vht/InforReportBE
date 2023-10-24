package com.pokemonreview.api.service;

import com.pokemonreview.api.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();
}
