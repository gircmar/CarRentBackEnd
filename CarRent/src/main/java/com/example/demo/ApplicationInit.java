package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Role;
import com.example.demo.enumerator.RoleEnumerator;
import com.example.demo.repository.RoleRepository;

@Component
public class ApplicationInit implements ApplicationRunner {
	
	@Autowired
	RoleRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(repository.findByRole(RoleEnumerator.ROLE_USER).isEmpty()) {
		Role user = new Role();
		user.setRole(RoleEnumerator.ROLE_USER);
		repository.save(user);
		}
		
		if(repository.findByRole(RoleEnumerator.ROLE_ADMIN).isEmpty()) {
			Role admin = new Role();
			admin.setRole(RoleEnumerator.ROLE_ADMIN);
			repository.save(admin);
			}
	}

}
