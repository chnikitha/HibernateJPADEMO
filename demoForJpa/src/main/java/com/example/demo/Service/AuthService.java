package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Auth;
import com.example.demo.exception.AuthenticationException;
import com.example.demo.repo.AuthRepo;

@Service
public class AuthService {

	@Autowired
	private AuthRepo authRepo;
	 public void authenticate(String username, String password) {
		  Optional<Auth> authOptional = authRepo.findByUsernameAndPassword(username, password);
		  if (!authOptional.isPresent()) {
	            throw new AuthenticationException("Invalid username or password");
	        }
	    }
	
	
}
