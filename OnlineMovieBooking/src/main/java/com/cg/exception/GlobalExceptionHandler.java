package com.cg.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	/**********************************
	 * Exception Handler
     *Method:     handleEntityNotFound
     *description:   		-handles Entitynotfound exception, it is raised  if the entity is not found
     *parameter              -gets the exception referrence as input
     *created by               -Polsani sandeep
**********************************/
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ExceptionResponse> handleEntityNotFound(EntityNotFoundException e)
	{
		return new ResponseEntity<>(new ExceptionResponse(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	
	
	
	/**********************************
	 * Exception Handler
     *Method:     handleBadArgumantException
     *description:   		-handles BadArgumantException exception, It is raised if the expected argument does not match with giver argument
     *parameter               -gets the exception referrence as input
     *@returns                 -ExceptionRsponse
     *created by               -Polsani sandeep
     *created date             -21-APR-2020
**********************************/
	@ExceptionHandler({BadArgumentException.class})
	public ResponseEntity<ExceptionResponse> handleBadArgumantException(BadArgumentException e)
	{
		return new ResponseEntity<>(new ExceptionResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	
	/**********************************
	 * Exception Handler
     *Method:     			handleNullPropertyException
     *description:   		-handles NullProperty exception, It is raised if the property is null
     *Exception                -gets the exception referrence as input
     *@returns                 -ExceptionResponse
     *created by               -Polsani sandeep
     *created date             -21-APR-2020
**********************************/
	@ExceptionHandler({NullPropertyException.class})
	public ResponseEntity<ExceptionResponse> handleNullPropertyException(NullPropertyException e)
	{
		return new ResponseEntity<>(new ExceptionResponse(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	
	/**********************************
	 * Exception Handler
     *Method:     			handleIllegalSeatStateChangeException
     *description:   		-handles IllegalSeatStateChangeException,It is raised if seat change is invalid
     *Exception                -gets the exception referrence as input
     *@returns                 -ExceptionResponse
     *created by               -Polsani sandeep
**********************************/
	@ExceptionHandler({IllegalSeatStateChangeException.class})
	public ResponseEntity<ExceptionResponse> handleIllegalSeatStateChangeException(IllegalSeatStateChangeException e)
	{
		return new ResponseEntity<>(new ExceptionResponse(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
	
	/**********************************
	 * Exception Handler
     *Method:     			handleNullPointerException
     *description:   		-handles NullProperty exception, It is raised if the return value is null
     *Exception                -gets the exception referrence as input
     *@returns                 -ExceptionResponse
     *created by               -Polsani sandeep
     *created date             -21-APR-2020
**********************************/
	@ExceptionHandler({NullPointerException.class})
	public ResponseEntity<ExceptionResponse> handleNullPropertyException(NullPointerException e)
	{
		return new ResponseEntity<>(new ExceptionResponse(e.getMessage()),HttpStatus.NOT_FOUND);
	}
	
}