package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.enumerator.CarBrandEnum;
import com.example.demo.enumerator.CarClassificationEnum;
import com.example.demo.enumerator.CarGearBox;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="car")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name="brand")
	private CarBrandEnum brand;
	
	@Column(name="name")
	@NotBlank (message="Name is required")
	private String name;
	
	@Column (name="production_date")
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date productionDate;
	
	@Column (name="license_plate")
	private String licensePlate;
	
	@Column (name="engine")
	private String engine;
	
	@Column (name="doors")
	private Integer doors;
	
	@Column(name="seats")
	private Integer seats;
	
	@Column (name="gear_box")
	@Enumerated(EnumType.STRING)
	private CarGearBox gearbox;
	
	@Column (name="classification")
	@Enumerated(EnumType.STRING)
	private CarClassificationEnum classification;
	
	@Column(name="price_per_day")
	
	private Double pricePerDay;
	
	private Boolean rented;
	
	@OneToMany (mappedBy="car",cascade= CascadeType.MERGE)
	private List<Rent> rents= new ArrayList<>();
	
}
