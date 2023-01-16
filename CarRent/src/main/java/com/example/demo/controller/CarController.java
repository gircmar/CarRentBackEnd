package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarDto;
import com.example.demo.service.CarService;

@CrossOrigin(origins = {"http://localhost:3000","http://127.0.0.1:3000"})
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired CarService carService;

	
	@GetMapping("/{id}")
	public CarDto findById(@PathVariable (name="id") Long id) {
		return carService.findById(id);
		
	}
	
	@GetMapping("")
	public List<CarDto> findAllCars() {
		carService.ListOfCarsWithActiveRents();
		carService.ListOfCarsWithFinishedRents();
		return carService.findAllCars();
	}
		
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("")
	public CarDto createCar( @RequestBody CarDto carDto) {
		return carService.createCar(carDto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public CarDto updateCar( @RequestBody CarDto carDto,@PathVariable(name="id") Long id) {
		return carService.updateCar(carDto);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable(name="id") Long id) {
		carService.deleteCar(id);
	}
	
	@GetMapping("/active")
	public void activeRentCars(){
		carService.ListOfCarsWithActiveRents();
	}
	
	@GetMapping("/notactive")
	public  void notActiveCars(){
		carService.ListOfCarsWithFinishedRents();
	}
}
