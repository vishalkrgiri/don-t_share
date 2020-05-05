package com.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {
	@ExceptionHandler(value = MovieBookingException.class)
	public ResponseEntity<Object> handleException(MovieBookingException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
