package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Auth;
import com.example.demo.repo.AuthRepo;

@Service
public class AuthService {

	@Autowired
	private AuthRepo authRepo;
	 public boolean authenticate(String username, String password) {
	        Auth auth = authRepo.findByUsernameAndPassword(username, password);
	        return auth != null;
	    }
	
	
}
