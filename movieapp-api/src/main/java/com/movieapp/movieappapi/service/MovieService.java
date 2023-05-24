package com.movieapp.movieappapi.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.movieapp.movieappapi.Exception.ExceptionHandlerAlreadyExist;
import com.movieapp.movieappapi.model.Movie;
import com.movieapp.movieappapi.model.SavedMovies;

@Service
public interface MovieService {
	
	public Movie saveMovie(Movie movie) throws ExceptionHandlerAlreadyExist;
	public SavedMovies saveMovies(SavedMovies movie) throws ExceptionHandlerAlreadyExist ;
	
	public ArrayList<Movie>getAll(String email);
	public Movie getbyTitle(String title);
	public Movie getbyEmail(String email);
	public ArrayList<SavedMovies>getAllTitle();
	public void delete(String title ,String email);
	public void deleteAdminpower(String title );
	public ArrayList<Movie>getallDetailes();

}
