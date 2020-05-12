package com.cg.exception;

public class ExceptionResponse {

	private String message;
	private String solution;
	

	
	public ExceptionResponse(String message) {
		super();
		this.message = message;
	}
	public ExceptionResponse(String message, String solution) {
		super();
		this.message = message;
		this.solution = solution;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	
	
	
	
}