package com.movieapp.auth.model;

	import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.HashIndexed;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;

	@Data
	@Document
	public class User {
		@Id			
		String email;
		String fullName;
		String password;
		long phoneNumber;
		
	}

