package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="rent")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Rent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column (name="start_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@Column (name="end_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	@Column (name="total_price")
	private Double totalPrice;
	
	@Column (name="total_price_with_discount")
	private Double totalPriceWithDiscount;
	
	@Column(name="discount")
	private String discount;
	
	@ManyToOne (cascade= CascadeType.MERGE)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne (cascade= CascadeType.MERGE)
	@JoinColumn(name="car_id")
	private Car car;
	
	
	
	
	
	
}
