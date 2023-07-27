package com.projects.api.webparking.services;

import com.projects.api.webparking.dtos.CreateOrFindUserDto;
import com.projects.api.webparking.entities.User;
import com.projects.api.webparking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findOrCreateUser(CreateOrFindUserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()) {
            return user.get();
        }
        return userRepository.save(new User(userDto.getEmail()));
    }
}
