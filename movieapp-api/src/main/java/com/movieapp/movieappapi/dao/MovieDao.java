package com.movieapp.movieappapi.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.movieapp.movieappapi.Exception.ExceptionHandlerAlreadyExist;
import com.movieapp.movieappapi.model.Movie;
import com.movieapp.movieappapi.model.SavedMovies;




@Repository
public class MovieDao {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Movie saveMovie(Movie movie ) throws ExceptionHandlerAlreadyExist {
		
		Movie one = getbyTitle(movie.getTitle());
		Movie two = getbyEmail(movie.getEmail());
		
		if(one != null && two !=null) {
			throw new ExceptionHandlerAlreadyExist();
		}
		
		return mongoTemplate.save(movie);
		
		
	}
	
public SavedMovies saveMovie(SavedMovies movie ) throws ExceptionHandlerAlreadyExist {
	SavedMovies one = getbyTitleAdmin(movie.getTitle());
	if(one != null)  {
		throw new ExceptionHandlerAlreadyExist();
	}
		
		return mongoTemplate.save(movie);
		
		
	}


	public void deleteAdminpower(String title ) {
	Query query=new Query();
	query.addCriteria(Criteria.where("title").is(title));
	 mongoTemplate.remove(query, SavedMovies.class);
}


	public ArrayList<Movie>getAll(String email){
		Query query=new Query();
		 query.addCriteria(Criteria.where("email").is(email));
		 ArrayList<Movie> result= (ArrayList<Movie>) mongoTemplate.find(query, Movie.class);
		 return result;
		
		
	}
	
	public ArrayList<SavedMovies>getAllTitle(){
		return (ArrayList<SavedMovies>) mongoTemplate.findAll(SavedMovies.class);
		
		
	}
	
	public ArrayList<Movie>getallDetailes(){
		return (ArrayList<Movie>) mongoTemplate.findAll(Movie.class);
		
		
	}
	
	public Movie getbyTitle(String title)
	{	
		Query query=new Query();
		query.addCriteria(Criteria.where("title").is(title));
		return mongoTemplate.findOne(query, Movie.class);
				
	}
	
	public SavedMovies getbyTitleAdmin(String title)
	{	
		Query query=new Query();
		query.addCriteria(Criteria.where("title").is(title));
		return mongoTemplate.findOne(query, SavedMovies.class);
				
	}
	
	
	
	public void delete(String title ,String email) {
		Query query=new Query();
		query.addCriteria(Criteria.where("title").is(title).and("email").is(email));
		 mongoTemplate.remove(query, Movie.class);
	}
	
	public Movie getbyEmail(String email)
	{	
		Query query=new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return mongoTemplate.findOne(query, Movie.class);
				
	}
	
	
	
}
