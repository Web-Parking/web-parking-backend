package com.projects.api.webparking.controllers;

import com.projects.api.webparking.dtos.CreateOrFindUserDto;
import com.projects.api.webparking.entities.User;
import com.projects.api.webparking.repositories.UserRepository;
import com.projects.api.webparking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createOrFindUser(@RequestBody CreateOrFindUserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findOrCreateUser(userDto));
    }
}
