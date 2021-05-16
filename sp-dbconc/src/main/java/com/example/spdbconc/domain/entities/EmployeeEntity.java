package com.example.spdbconc.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*
 * created table for Employee
 */
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	@Id
	@Column(name = "EmployeeId")
	private Long id;
	@Column(name = "EmployeeName")
	private String name;
	@Column(name = "EmployeeCompany")
	private String company;

	@OneToOne(cascade = CascadeType.ALL)
	private AddressEntity addressentity;

	public EmployeeEntity(Long id, String name, String company, AddressEntity addressentity) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
		this.addressentity = addressentity;
	}

	public EmployeeEntity() {
		super();
	}

	public AddressEntity getAddressentity() {
		return addressentity;
	}

	public void setAddressentity(AddressEntity addressentity) {
		this.addressentity = addressentity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Employee{" + "id = " + this.id + "," + "name = " + this.name + "," + " company = " + this.company + ","
				+ "adress = " + this.addressentity.getHouseNumber() + ".}";
	}

}
