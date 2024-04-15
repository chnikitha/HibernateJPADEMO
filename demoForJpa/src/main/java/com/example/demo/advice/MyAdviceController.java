package com.example.demo.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.exception.AuthenticationException;
import com.example.demo.exception.NoSuchUsernameElementException;
import com.example.demo.vo.ResponseVO;

@ControllerAdvice
public class MyAdviceController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<ResponseVO> handleEmptyInput(AuthenticationException authenticationException )
	{
		 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseVO(HttpStatus.UNAUTHORIZED.value(), "AUTH_001", "Username/password is empty, Please enter username or password"));
		//return new ResponseEntity<String>("Username/password is empty, Please enter username or password", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchUsernameElementException.class)
	public ResponseEntity<ResponseVO> handleEmptyInput(NoSuchUsernameElementException noSuchUsernameElementException )
	{
		 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseVO(HttpStatus.UNAUTHORIZED.value(), "AUTH_001", "Username and password doesn't exists"));
		//return new ResponseEntity<String>("Username/password is empty, Please enter username or password", HttpStatus.BAD_REQUEST);
	}


	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		//return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
		return new ResponseEntity<Object> ("Not found",HttpStatus.NOT_FOUND);
		
	}
	
	
	

}
