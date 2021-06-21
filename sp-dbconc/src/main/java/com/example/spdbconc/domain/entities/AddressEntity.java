package com.example.spdbconc.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * Created table for address
 */
@Entity
@Table(name = "EAddress")
@NoArgsConstructor
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Housenumber")
	@Getter
	@Setter
	private Long houseNumber;

	@NotNull(message = "streetname should not be null")
	@Size(min = 2, message = "StreetName atleast should have 2 characters")
	@Column(name = "Streetname")
	@Getter
	@Setter
	private String streetName;

	@NotNull(message = "city should not be null")
	@Size(min = 2, message = "City atleast should have 2 characters")
	@Column(name = "City")
	@Getter
	@Setter
	private String city;

	@JsonIgnore
	@OneToOne(mappedBy = "addressentity")
	@Getter
	@Setter
	private EmployeeEntity employeeEntity;

	public AddressEntity(String streetName, String city, String country, EmployeeEntity employeeEntity) {
		this.streetName = streetName;
		this.city = city;
		this.employeeEntity = employeeEntity;
	}
}
