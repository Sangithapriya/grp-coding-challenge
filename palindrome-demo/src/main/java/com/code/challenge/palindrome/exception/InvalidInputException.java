package com.code.challenge.palindrome.exception;

public class InvalidInputException extends RuntimeException {

	/**
	 * Default serial version id
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
    public InvalidInputException(String message) {
        super(message);
        this.message = message;
    }
    
    public InvalidInputException() {
    }
}
