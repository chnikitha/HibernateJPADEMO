package com.example.demo.exception;

public class StudentServiceException extends RuntimeException {

	  
	private static final long serialVersionUID = 1L;

	public StudentServiceException(String message) {
	        super(message);
	    }
	}