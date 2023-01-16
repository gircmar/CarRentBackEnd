package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user1")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="name")
	@NotBlank (message="Name is required")
	private String name;
	
	@Column(name="last_name")
	@NotBlank (message="Last name is required")
	private String lastName;
	
	@Column(name="email")
	@Email(message="Email is required")
	
	private String email;
	
	@Column (name="date_of_birth")
    @JsonFormat(pattern="yyyy-MM-dd")
	
	private Date dateOfBirth;
	
	
	@Column (name="address")
	private String address;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column (name="driver_license_number")
	private String driverLicenseNumber;

	@OneToMany (mappedBy="user")
	private List<Rent> rents= new ArrayList<>();
	
	@Column(name="password")
	private String password;
	
	
	@ManyToMany (cascade= CascadeType.ALL)
	@JoinTable(
			name="user_roles",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="role_id")
			)
	private List <Role> roles=new ArrayList<>();

	
	
	

}
