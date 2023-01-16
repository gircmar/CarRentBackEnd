package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.enumerator.RoleEnumerator;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@Service
public class AuthService {
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	@Autowired
	UserMapper userMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public UserDto signUp(SignUpDto signupdto) throws Exception {
		if(userRepo.findByEmail(signupdto.getEmail()).isPresent()) {
			throw new Exception("Email "+ signupdto.getEmail()+" is already in use");
			
		}
		if (!signupdto.getPassword().equals(signupdto.getRepeatPassword())) {
			throw new Exception("Passwords do not match");
		}
		User newUser = new User();
		newUser.setName(signupdto.getName());
		newUser.setLastName(signupdto.getLastName());
		newUser.setEmail(signupdto.getEmail());
		newUser.setPassword(signupdto.getPassword());
		
		Role userRole=roleRepo.findByRole(RoleEnumerator.ROLE_USER).orElseThrow();
		
		List<Role> userRoles=new ArrayList<>();
		userRoles.add(userRole);
		newUser.setRoles(userRoles);
		newUser.setPassword(passwordEncoder.encode(signupdto.getPassword()));
		userRepo.save(newUser);
		return userMapper.toDto(newUser);
		
		
		
	}

}
