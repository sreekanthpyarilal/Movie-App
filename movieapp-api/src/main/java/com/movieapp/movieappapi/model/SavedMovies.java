package com.movieapp.movieappapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document

public class SavedMovies {

   	@JsonProperty("Title")
	String title;
	 @JsonProperty("Released")
    String released;
    float imdbRating;
    @JsonProperty("Poster")
    String Poster;
    String email;
    
    float userrating;
}
