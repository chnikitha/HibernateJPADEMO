package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AuthService;
import com.example.demo.Service.StudentService;
import com.example.demo.entity.Auth;
import com.example.demo.entity.Student;
import com.example.demo.exception.AuthenticationException;
import com.example.demo.exception.StudentServiceException;
import com.example.demo.repo.AuthRepo;
import com.example.demo.repo.StudentRepo;
import com.example.demo.vo.ResponseVO;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AuthRepo authRepo;
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("/api/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{ 
		return studentService.saveStudent(student)	;	
	}
	
    @PostMapping("/api/auth")
	public ResponseEntity<Auth> saveAuth(@RequestBody Auth auth)
	{ 
		return studentService.saveAuth(auth)	;	
	}
 
	
	
	@GetMapping("/api/students")
	public ResponseEntity<?> getStudents(@RequestHeader(value = "SortBy", defaultValue = "name") String sortBy, 
			@RequestHeader(value = "OrderBy", defaultValue = "ascending") String orderBy, @RequestHeader("username") String username, @RequestHeader("password") String password)
	{
		    
		
		 try 
		   {
	            authService.authenticate(username, password);
	            ResponseEntity<List<Student>> students = studentService.getStudents(sortBy, orderBy);
	            return ResponseEntity.ok(students);
	        }
		 catch (AuthenticationException e)
		 {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseVO(HttpStatus.UNAUTHORIZED.value(), "AUTH_001", e.getMessage()));
	       } 
		 
		 catch (Exception e)
		 {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseVO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "GEN_001", "Internal server error"));
	        }
	    }
	
			
	
	
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id) 
	{
		return studentService.getStudent(id);
	}
	
	@PutMapping("/api/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student stud) 
	{
		return studentService.updateStudent(id, stud);
	}
	@DeleteMapping("/api/students/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id) 
	{
		return studentService.deleteStudent(id);
	}


}
