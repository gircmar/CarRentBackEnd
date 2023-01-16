package com.example.demo.mapper;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDto;

import com.example.demo.entity.Rent;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.RentRepository;



@Service
public class UserMapper {
	
	@Autowired RentRepository rentRepository;
	@Autowired CarRepository carRepository;
	public UserDto toDto(User entity) {
		if(entity==null) {
			return null;
		}
		UserDto dto=new UserDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setLastName(entity.getLastName());
		dto.setEmail(entity.getEmail());
		dto.setDateOfBirth(entity.getDateOfBirth());
		dto.setAddress(entity.getAddress());
		dto.setPhoneNumber(entity.getPhoneNumber());
		dto.setDriverLicenseNumber(entity.getDriverLicenseNumber());
		dto.setRentsIds(getRentsIds(entity));
		dto.setRolesIds(getRolesIds(entity));
		
		
		return dto;
	}
	
	public User fromDto(UserDto dto) {
		if(dto==null) {
			return null;
		}
		User entity=new User();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setDateOfBirth(dto.getDateOfBirth());
		entity.setAddress(dto.getAddress());
		entity.setPhoneNumber(dto.getPhoneNumber());
		entity.setDriverLicenseNumber(dto.getDriverLicenseNumber());
		entity.setRents(findAllRentsByIdList(dto.getRentsIds()));
		
		return entity;
	}
	
	public List<UserDto> toDtoList(List<User> entities){
		List<UserDto> dtos=new ArrayList<>();
		for (User entity : entities) {
			dtos.add(toDto(entity));
		}
		return dtos;
	}
	
	public List<Long> getRentsIds(User user){
		List<Rent> rents = user.getRents();
		List<Long> rentsIdList= new ArrayList<>();
		for (Rent entity: rents) {
			rentsIdList.add(entity.getId());
			
		}
		return rentsIdList;
	}
	public List<Rent> findAllRentsByIdList(List<Long>ids){
		List<Rent> rents= new ArrayList<>();
		if(ids!=null) {
			rentRepository.findAllById(ids).forEach(rents::add);
		}
		return rents;
	}
	
	public List<Long> getRolesIds(User user){
		List<Role> roles=user.getRoles();
		List <Long> rolesIdsList=new ArrayList<>();
		for (Role entity: roles) {
			rolesIdsList.add(entity.getId());
		}
		return rolesIdsList;
	}
	

}
