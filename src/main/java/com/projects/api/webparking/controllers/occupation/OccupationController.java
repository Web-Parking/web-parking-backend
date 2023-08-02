package com.projects.api.webparking.controllers.occupation;

import com.projects.api.webparking.controllers.exceptions.StandardError;
import com.projects.api.webparking.dtos.CodeOccupationDto;
import com.projects.api.webparking.dtos.CreateOrFindUserDto;
import com.projects.api.webparking.entities.Occupation;
import com.projects.api.webparking.entities.User;
import com.projects.api.webparking.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userId}/occupations")
public class OccupationController {
	private final UserService userService;
	@Autowired
	public OccupationController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping
	public ResponseEntity<Object> getOccupation(@PathVariable("userId") String userId) {
		Occupation occupation = userService.createOccupation(userId);
		return ResponseEntity.status(HttpStatus.OK).body(occupation);
	}

	@PatchMapping
	public ResponseEntity<Void> releaseOccupation(@PathVariable("userId") String userId, @RequestBody CodeOccupationDto codeOccupationDto) {
		userService.releaseOccupation(userId, codeOccupationDto.getCode());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
