package com.movieapp.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class UserNotFoundHandler {

	@ExceptionHandler(value=UserNotFoundException.class)
	public  ResponseEntity<String> userNotFoundException(UserNotFoundException notFoundException){
		return new ResponseEntity<String>("User Not found ",HttpStatus.NOT_ACCEPTABLE);
		
		
	}
}










