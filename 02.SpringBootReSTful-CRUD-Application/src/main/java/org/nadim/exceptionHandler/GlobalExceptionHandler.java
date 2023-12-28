package org.nadim.exceptionHandler;

import org.nadim.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> studentNotFoundError( StudentNotFoundException snfe){
		ResponseEntity<String> response = new ResponseEntity<>(snfe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return response;
	}
}
