package com.movieapp.auth.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.auth.exception.UserAlreadyRegisteredException;
import com.movieapp.auth.exception.UserNotFoundException;
import com.movieapp.auth.model.User;




@Repository
public class UserDao {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	public User saveuser(User user) throws UserAlreadyRegisteredException {
		
		User user2=	getEmail(user.getEmail());
		if(user2!=null)
		{
			throw new UserAlreadyRegisteredException() ;
		}		
		
		return mongoTemplate.save(user);
	}
				
	public User findByuserNameAndPassword(String email, String password) throws UserNotFoundException {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("email").is(email).and("password").is(password));
		User found=  mongoTemplate.findOne(query, User.class);
		
		if(found == null) {
			
			throw new UserNotFoundException();
		}
		
		return mongoTemplate.findOne(query, User.class);
		
				
	}
		
	public User getEmail(String email) {
		Query query=new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return mongoTemplate.findOne(query, User.class);
	
	
}
	
	
	public ArrayList<User> getAllbyemail(String email){
		Query query=new Query();
		 query.addCriteria(Criteria.where("email").is(email));
		 ArrayList<User> result= (ArrayList<User>) mongoTemplate.find(query, User.class);
		 return result;
		
		
	}
	
	public ArrayList<User> getAllUser(){
		Query query=new Query();
		 		 
		return (ArrayList<User>) mongoTemplate.findAll(User.class);
		
		
	}
	
	public User updatePassword(User user) {
		
		
		return mongoTemplate.save(user);
		
		
	}
	
	
				
		
	}



