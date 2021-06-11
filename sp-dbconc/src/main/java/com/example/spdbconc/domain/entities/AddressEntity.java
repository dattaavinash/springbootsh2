package com.example.spdbconc.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Created table for address
 */
@Entity
@Table(name = "EAddress")
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Housenumber")
	private Long houseNumber;

	@NotNull(message = "streetname should not be null")
	@Size(min = 2, message = "StreetName atleast should have 2 characters")
	@Column(name = "Streetname")
	private String streetName;

	@NotNull(message = "city should not be null")
	@Size(min = 2, message = "City atleast should have 2 characters")
	@Column(name = "City")
	private String city;

	@JsonIgnore
	@OneToOne
	@JoinColumn(referencedColumnName = "EmployeeId", name = "emp_id")
	private EmployeeEntity employeeEntity;

	public AddressEntity(String streetName, String city, String country, EmployeeEntity employeeEntity) {
		super();
		this.streetName = streetName;
		this.city = city;
		this.employeeEntity = employeeEntity;
	}

	public AddressEntity() {

	}

	public Long getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(Long houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

}
