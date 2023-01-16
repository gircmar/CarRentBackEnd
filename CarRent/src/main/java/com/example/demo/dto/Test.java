package com.example.demo.dto;

import javax.validation.constraints.NotBlank;

public class Test {
	
	@NotBlank
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	
}
