package com.example.spdbconc.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Getter
@Setter
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Housenumber")
	private Long houseNumber;

	@Column(name = "Streetname")
	private String streetName;

	@Column(name = "City")
	private String city;

	@JsonIgnore
	@OneToOne(mappedBy = "addressentity")
	private EmployeeEntity employeeEntity;

	public AddressEntity(String streetName, String city, String country, EmployeeEntity employeeEntity) {
		this.streetName = streetName;
		this.city = city;
		this.employeeEntity = employeeEntity;
	}
}
