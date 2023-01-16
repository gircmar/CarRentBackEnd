package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Rent;


public interface RentRepository extends CrudRepository <Rent,Long> {
	
	List<Rent> findAllByOrderByIdAsc ();
	
	List<Rent> findAllByOrderByIdDesc ();
}
