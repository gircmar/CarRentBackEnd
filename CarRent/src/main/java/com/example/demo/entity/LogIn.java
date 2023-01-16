package com.example.demo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogIn {

	@Email
	@Size(min=6,max=30)
	private String Email;
	
	
	@NotBlank
	@Size(min=6,max=30)
	private String password;
}
