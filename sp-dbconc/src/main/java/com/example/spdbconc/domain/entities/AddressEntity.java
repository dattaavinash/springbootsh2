package com.example.spdbconc.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * Created table for address
 */
@Entity
@Table(name = "EAddress")
public class AddressEntity {
	@Id
	@Column(name = "Housenumber")
	private Long houseNumber;
	@Column(name = "Streetname")
	private String streetName;
	@Column(name = "City")
	private String city;
	@Column(name = "Country")
	private String country;

	@OneToOne(mappedBy = "addressentity")
	private EmployeeEntity employeeEntity;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
