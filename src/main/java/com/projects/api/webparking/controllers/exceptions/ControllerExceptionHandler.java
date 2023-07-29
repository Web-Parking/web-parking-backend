package com.projects.api.webparking.controllers.exceptions;

import com.projects.api.webparking.controllers.occupation.OccupationController;
import com.projects.api.webparking.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class ControllerExceptionHandler {
//	@ExceptionHandler(EntityNotFoundException.class)
//	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException exception, HttpServletRequest request) {
//		não está funcionando, a requisição
//		todo corrigir, aula https://www.youtube.com/watch?v=MAv7xgnSD-s
//	}

}
