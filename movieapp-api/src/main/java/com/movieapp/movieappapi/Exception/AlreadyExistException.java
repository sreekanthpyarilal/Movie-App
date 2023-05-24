package com.movieapp.movieappapi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class AlreadyExistException {

	@ExceptionHandler(value=ExceptionHandlerAlreadyExist.class)
	public  ResponseEntity<String> exceptionHandlerAlreadyExist(ExceptionHandlerAlreadyExist alreadyExist){
		return new ResponseEntity<String>("Already in Favourite List ",HttpStatus.NOT_ACCEPTABLE);
	}
}
















