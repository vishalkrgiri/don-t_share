package com.cg.exception;

public class NullPropertyException extends Exception {

	private String message;
	public NullPropertyException() {
		// TODO Auto-generated constructor stub
		
	}
	public NullPropertyException(String s)
	{
		message=s;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}