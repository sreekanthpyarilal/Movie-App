package com.movieapp.auth.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.auth.dao.UserDao;
import com.movieapp.auth.exception.UserAlreadyRegisteredException;
import com.movieapp.auth.exception.UserNotFoundException;
import com.movieapp.auth.model.User;
import com.movieapp.auth.service.UserService;
import com.movieapp.auth.service.UserServiceImpl;




@CrossOrigin
@RestController
@RequestMapping("signup")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	
	@PostMapping
	public ResponseEntity<User> saveuser(@RequestBody User user) throws UserAlreadyRegisteredException{
		{
			User savedUser= userservice.saveUser(user) ;
			return new ResponseEntity<User>(savedUser,HttpStatus.CREATED);
			
		}

		
}
	@GetMapping("/{email}/{password}")
	public ResponseEntity<?> findByuserNameAndPassword(@PathVariable  String email,@PathVariable String password) throws UserNotFoundException
	{
		User searchUser=userservice.findByuserNameAndPassword(email,password);		
					
		if(searchUser != null) {
			
			return new ResponseEntity<User>(searchUser ,HttpStatus.OK);
		}
		return null;
		
		
		
	}
	
	
//	@PostMapping("/login")
//	public ResponseEntity<String> login(@RequestBody User user) throws UserNotFoundException
//	{
//		try {
//		userservice.findByuserNameAndPassword(user.getEmail(),user.getPassword());		
//		return new ResponseEntity<String>(getToken(user, user.getEmail(),user.getPassword()),HttpStatus.OK);
//		} catch (UserNotFoundException e) {
//			
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
//		}
//	}

		
	
	
	@GetMapping("/{email}")
	public ResponseEntity<User> getEmail(@PathVariable String email) 
	{
	
		User searchemail=userservice.getEmail(email);
		

		return new ResponseEntity<User>(searchemail,HttpStatus.OK);
		
	}
	
	@GetMapping("/all/{email}")
	public  ArrayList<User> getAllbyemail (@PathVariable String email){
		ArrayList<User> users=userservice.getAllbyemail(email);
		return  users;
		
	}
	
	@GetMapping("/alluser")
	public  ArrayList<User> user(){
		ArrayList<User> users=userservice.getAllUser();
		return  users;
		
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<User> updateUserPassword(@RequestBody User user) 
	{
	User newuser= userservice.updatePassword(user);

	return new ResponseEntity<User>(newuser,HttpStatus.CREATED);
	}
	
	
	
//	public String getToken(@RequestBody User user , String email, String password) throws UserNotFoundException {
//		return Jwts.builder().setId(email).setSubject(password).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//
//	}


}
