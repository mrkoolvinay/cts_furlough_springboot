package com.vinay.rest.webservices.restfulwebservices.data;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Size(min=2, message="Name should be greater than 2 characters")
	@ApiModelProperty(notes="Name should be greater than 2 characters")
	@Column(name="NAME")
	private String name;
	
	@Past(message="Date should be past date")
	@Column(name="DOB")
	private Date dateOfBirth;
}
