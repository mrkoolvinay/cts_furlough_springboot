package com.vinay.rest.webservices.restfulwebservices.data;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	private Integer id;
	
	@Size(min=2, message="Name should be greater than 2 characters")
	private String name;
	
	@Past(message="Date should be past date")
	private Date dateOfBirth;
}
