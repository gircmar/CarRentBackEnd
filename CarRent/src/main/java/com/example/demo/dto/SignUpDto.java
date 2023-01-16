package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpDto {
	
	@NotBlank
	@Size(min=3,max=15)
	private String name;
	
	@NotBlank
	@Size(min=3,max=15)
	private String lastName;
	
	@Email
	@Size(max=50)
	private String email;
	
	@NotBlank
	@Size(min=6,max=20)
	private String password;
	
	
	@NotBlank
	@Size(min=6,max=20)
	private String repeatPassword;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRepeatPassword() {
		return repeatPassword;
	}


	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	
	
}

