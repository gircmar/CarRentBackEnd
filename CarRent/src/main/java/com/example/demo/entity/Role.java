package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.enumerator.RoleEnumerator;


@Entity
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private RoleEnumerator role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public RoleEnumerator getRole() {
		return role;
	}

	public void setRole(RoleEnumerator role) {
		this.role = role;
	}

	public Role(Long id, RoleEnumerator role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Role() {
	
	}
}
