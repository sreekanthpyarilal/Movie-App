package com.movieapp.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
@Component
public class RegisteredUserHandler {
	
	@ExceptionHandler(value=UserAlreadyRegisteredException.class)	
	public  ResponseEntity<String> registeredUserException(UserAlreadyRegisteredException alreadyRegisteredException)
	{
	return new ResponseEntity<String>("User Already Registered",HttpStatus.NOT_ACCEPTABLE);
	}
	}






