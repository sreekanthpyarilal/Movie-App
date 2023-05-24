package com.movieapp.auth.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.movieapp.auth.exception.UserAlreadyRegisteredException;
import com.movieapp.auth.exception.UserNotFoundException;
import com.movieapp.auth.model.User;



@Service
public interface UserService {
	
	public User saveUser(User user) throws UserAlreadyRegisteredException ;
	public User findByuserNameAndPassword(String email, String password) throws UserNotFoundException ;
	public User getEmail(String email) ;
	public ArrayList<User> getAllUser();
	public  ArrayList<User> getAllbyemail(String email); 
	public User updatePassword(User user) ;
	

}
