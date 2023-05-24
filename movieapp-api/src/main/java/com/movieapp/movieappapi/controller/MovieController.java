package com.movieapp.movieappapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.movieappapi.Exception.ExceptionHandlerAlreadyExist;
import com.movieapp.movieappapi.model.Movie;
import com.movieapp.movieappapi.model.SavedMovies;
import com.movieapp.movieappapi.service.MovieService;



@CrossOrigin
@RestController
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	MovieService movieservice;

	@PostMapping
	public  ResponseEntity<Movie> saveMovie(@RequestBody Movie movie)  throws ExceptionHandlerAlreadyExist{
		Movie savedMovie= movieservice.saveMovie(movie) ;
		return new ResponseEntity<Movie>(savedMovie,HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/main")
	public  ResponseEntity<SavedMovies> saveMovie(@RequestBody SavedMovies movie) throws ExceptionHandlerAlreadyExist{
		SavedMovies savedMovie= movieservice.saveMovies(movie) ;
		return new ResponseEntity<SavedMovies>(savedMovie,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/fav/{email}")
	public  ArrayList<Movie> getAll(@PathVariable String email){
		ArrayList<Movie> movielist=movieservice.getAll(email);
		return  movielist;
		
	}
	
	@GetMapping("/foradmin")
	public  ArrayList<Movie> getallDetailes(){
		ArrayList<Movie> movielist=movieservice.getallDetailes();
		return  movielist;
		
	}
	
	@GetMapping("/{title}")
	public ResponseEntity<Movie> getbyTitle(@PathVariable String title) {
		Movie savedMovie= movieservice.getbyTitle(title) ;
		return new ResponseEntity<Movie>(savedMovie,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{title}/{email}")
	public void delete(@PathVariable String title,@PathVariable String email) {
		movieservice.delete(title, email);
		
	}
	
	@DeleteMapping("/admin/{title}")
	public void delete(@PathVariable String title) {
		movieservice.deleteAdminpower(title);
		
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<Movie> getbyEmail(@PathVariable String email) {
		Movie savedMovie= movieservice.getbyEmail(email) ;
		return new ResponseEntity<Movie>(savedMovie,HttpStatus.OK);
	}
	
	@GetMapping()
	public  ArrayList<SavedMovies>getAllTitle(){
		return movieservice.getAllTitle();
				
	}

}
