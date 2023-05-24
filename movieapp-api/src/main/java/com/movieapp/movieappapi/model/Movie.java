package com.movieapp.movieappapi.model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Document


public class Movie {
	
	
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
