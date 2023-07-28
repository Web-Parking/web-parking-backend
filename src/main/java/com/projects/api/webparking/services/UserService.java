package com.projects.api.webparking.services;

import com.projects.api.webparking.dtos.CreateOrFindUserDto;
import com.projects.api.webparking.entities.Occupation;
import com.projects.api.webparking.entities.User;
import com.projects.api.webparking.repositories.OccupationRepository;
import com.projects.api.webparking.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OccupationRepository occupationRepository;

    public User findOrCreateUser(CreateOrFindUserDto userDto) {
        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()) {
            return user.get();
        }
        return userRepository.save(new User(userDto.getEmail()));
    }

    public Occupation createOccupation(String userId) throws EntityNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new EntityNotFoundException("Usuário não encontrado");
        }
        return occupationRepository.save(new Occupation(user.get()));
    }
}
