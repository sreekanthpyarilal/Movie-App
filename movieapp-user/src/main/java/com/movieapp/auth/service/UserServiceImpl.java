package com.movieapp.auth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.auth.dao.UserDao;
import com.movieapp.auth.exception.UserAlreadyRegisteredException;
import com.movieapp.auth.exception.UserNotFoundException;
import com.movieapp.auth.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	UserDao userdao;
	
	
	@Override
	public User saveUser(User user) throws UserAlreadyRegisteredException{
		
		return userdao.saveuser(user);
	}


	@Override
	public User findByuserNameAndPassword(String email, String password) throws UserNotFoundException  {
		User user=userdao.findByuserNameAndPassword(email, password) ;
		if(user ==null) {
			return null;
		}
		return user;
	}


	@Override
	public User getEmail(String email)  {
		
		return userdao.getEmail(email) ;
	}


	@Override
	public ArrayList<User> getAllbyemail(String email) {
		
		return userdao.getAllbyemail(email);
	}


	@Override
	public User updatePassword(User user)  {
		
		return userdao.updatePassword(user);
	}


	@Override
	public ArrayList<User> getAllUser() {
		
		return userdao.getAllUser();
	}





	

	}


