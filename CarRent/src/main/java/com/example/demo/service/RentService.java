package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RentDto;
import com.example.demo.entity.Rent;
import com.example.demo.mapper.RentMapper;
import com.example.demo.repository.RentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

@Service
public class RentService {
@Autowired RentMapper rentMapper;
@Autowired RentRepository rentRepository;
@Autowired ObjectMapper objectMapper;

public RentDto findById (Long id) {
	Rent rent = rentRepository.findById(id).orElse(null);
	return rentMapper.toDto(rent);
}

public List<RentDto> findAllRents(){
	List <Rent> rent=(List<Rent>) rentRepository.findAllByOrderByIdAsc();
	return rentMapper.toDtoList(rent);
}
public RentDto createRent(RentDto rentDto) {
	Rent rent=rentMapper.fromDto(rentDto);
	rentRepository.save(rent);
	return rentMapper.toDto(rent);
}
public RentDto updateRent (RentDto rentDto) {
	Rent rent = rentMapper.fromDto(rentDto);
	rentRepository.save(rent);
	return rentMapper.toDto(rent);
}
public void deleteRent (Long id) {
	rentRepository.deleteById(id);
}
public RentDto applyPatchToCustomer(JsonPatch patch,RentDto rentDto) throws JsonProcessingException, IllegalArgumentException, JsonPatchException {
	JsonNode patched= patch.apply(objectMapper.convertValue(rentDto, JsonNode.class));
	return objectMapper.treeToValue(patched, RentDto.class);
}

public List<RentDto> findAllByUserId(Long id) {
	List <Rent> rents=(List<Rent>) rentRepository.findAllByOrderByIdDesc();
	List<RentDto> dtos= new ArrayList<>();
	for (Rent entity : rents) {
		if (entity.getUser().getId().equals(id)) {
			dtos.add(rentMapper.toDto(entity));
		}
	}
	return dtos;
}

public List<Long> activeRentsCarsIdsList(){
	LocalDate date= java.time.LocalDate.now();
	List<Long> carIds=new ArrayList<>();
	List<RentDto> rents= findAllRents();
	for(RentDto rent: rents) {
		if (date.isAfter(rent.getStartDate())&&date.isBefore(rent.getEndDate())) {
			
			carIds.add(rent.getCarId());
		}
	}
	return carIds;
}

public List<Long> finishedRentsCarsIdsList(){
	LocalDate date= java.time.LocalDate.now();
	List<Long> carIds=new ArrayList<>();
	List<RentDto> rents= findAllRents();
	for(RentDto rent: rents) {
		if (!(date.isAfter(rent.getStartDate())&&date.isBefore(rent.getEndDate()))) {
			carIds.add(rent.getCarId());
		}
	}
	return carIds;
}



}
