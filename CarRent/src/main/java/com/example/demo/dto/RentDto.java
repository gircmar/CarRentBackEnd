package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Date;

import com.example.demo.entity.Car;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentDto {

	
	private Long id;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	private Double totalPrice;
	
	private Double totalPriceWithDiscount;
	
	private String discount;
	
	private Long userId;
	
	private Long carId;
	
}
