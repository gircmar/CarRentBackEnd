package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Car;

public interface CarRepository extends CrudRepository <Car,Long> {
	
	List<Car> findAllByOrderByIdAsc ();

}
