package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserDto {
	private Long id;
	
	
	@NotBlank (message="Name is required")
	private String name;
	
	
	@NotBlank (message="Last name is required")
	private String lastName;
	
	@Email(message="Email is required")
	private String email;
	
	
    @JsonFormat(pattern="yyyy-MM-dd")
  
	private Date dateOfBirth;
	
	@NotBlank
	private String address;
	
	@NotBlank (message="Date of birth is required")
	private String phoneNumber;
	
	private String driverLicenseNumber;
	
	private List<Long> rentsIds= new ArrayList<>();
	
	private List<Long> rolesIds= new ArrayList<>();
	
	
	
	

}
