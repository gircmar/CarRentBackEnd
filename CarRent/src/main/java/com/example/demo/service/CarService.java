package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.entity.Rent;
import com.example.demo.entity.User;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {
	@Autowired CarMapper carMapper;
	@Autowired CarRepository carRepository;
	@Autowired RentService rentService;

	public CarDto findById(Long id ) {
		Car car=carRepository.findById(id).orElse(null);
		return carMapper.toDto(car);
	}
	public List<CarDto> findAllCars(){
		List <Car> cars=(List<Car>) carRepository.findAllByOrderByIdAsc();
		return carMapper.toDtoList(cars);
	}
	
	public CarDto createCar(CarDto carDto) {
		Car car=carMapper.fromDto(carDto);
		carRepository.save(car);
		return carMapper.toDto(car);
	}
	
	public CarDto updateCar (CarDto carDto) {
		Car car2 = carRepository.findById(carDto.getId()).orElse(null);
		Car car = carMapper.fromDto(carDto);
		car.setRented(car2.getRented());
		carRepository.save(car);
		return carMapper.toDto(car);
	}
	public void deleteCar (Long id) {
		carRepository.deleteById(id);
	}
	
	public void ListOfCarsWithActiveRents(){
		List <Long> ids=rentService.activeRentsCarsIdsList();
		if(ids!=null) {
			carRepository.findAllById(ids).forEach(t -> t.setRented(true));
		}
		
	}
	
	public void ListOfCarsWithFinishedRents(){
		List <Long> ids=rentService.finishedRentsCarsIdsList();
		if(ids!=null) {
			carRepository.findAllById(ids).forEach(t -> t.setRented(false) );
		}
		
	}
	
	
}
