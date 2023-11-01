package com.information.api.controllers;

import com.information.api.models.UserEntity;
import com.information.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("user")
    public ResponseEntity<?> updateUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        boolean isDelete = userService.deleteUser(id);
        if (isDelete) return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}
