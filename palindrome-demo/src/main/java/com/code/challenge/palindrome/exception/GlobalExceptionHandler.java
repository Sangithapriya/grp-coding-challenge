package com.code.challenge.palindrome.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<String> invalidInputException(InvalidInputException invalidInputException) {
		return new ResponseEntity<String>("Invalid Input Exception", HttpStatus.BAD_REQUEST);
	}
}
