package com.movieapp.movieappapi.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.movieappapi.Exception.ExceptionHandlerAlreadyExist;
import com.movieapp.movieappapi.dao.MovieDao;
import com.movieapp.movieappapi.model.Movie;
import com.movieapp.movieappapi.model.SavedMovies;
@Service
public class MovieserviceImpl implements MovieService{

	@Autowired 
	MovieDao moviedao;
	
	
	
	
	@Override
	public Movie saveMovie(Movie movie)  throws ExceptionHandlerAlreadyExist {
		
		return moviedao.saveMovie(movie) ;
	}

	@Override
	public ArrayList<Movie> getAll(String email) {
		
		return moviedao.getAll(email);
	}

	@Override
	public void delete(String title,String email) {
		
		 moviedao.delete(title, email);
		
		 
	}

	@Override
	public Movie getbyTitle(String title) {
		
		return moviedao.getbyTitle(title);
	}

	@Override
	public Movie getbyEmail(String email) {
		
		return moviedao.getbyEmail(email);
	}

	@Override
	public ArrayList<SavedMovies> getAllTitle() {
		
		return moviedao.getAllTitle();
	}



	@Override
	public SavedMovies saveMovies(SavedMovies movie) throws ExceptionHandlerAlreadyExist{
		
		return moviedao.saveMovie(movie);
	}

	@Override
	public void deleteAdminpower(String title) {
		moviedao.deleteAdminpower(title);
		
	}

	@Override
	public ArrayList<Movie> getallDetailes() {
		
		return moviedao.getallDetailes();
	}


}
