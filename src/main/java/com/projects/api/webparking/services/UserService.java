package com.projects.api.webparking.services;

import com.projects.api.webparking.dtos.CreateOrFindUserDto;
import com.projects.api.webparking.entities.Occupation;
import com.projects.api.webparking.entities.User;
import com.projects.api.webparking.repositories.OccupationRepository;
import com.projects.api.webparking.repositories.UserRepository;
import com.projects.api.webparking.services.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OccupationRepository occupationRepository;

    public UserService() {
    }

    public User findOrCreateUser(CreateOrFindUserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail()).orElseGet(
                () -> userRepository.save(new User(userDto.getEmail()))
        );
    }

    public Occupation createOccupation(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return occupationRepository.save(new Occupation(user));
    }

    @Transactional
    public void releaseOccupation(String userId, String codeOccupation) {
        User user = userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("User not found"));
        int affectedRows = occupationRepository.updateOccupationSetStatusForCode(Occupation.OccupationStatus.RELEASED, codeOccupation);
        if(affectedRows == 0) {
            throw new EntityNotFoundException("Incorrect Code");
        }
    }
}
