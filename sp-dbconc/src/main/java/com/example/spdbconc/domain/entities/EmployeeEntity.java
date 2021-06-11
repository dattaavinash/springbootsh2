package com.example.spdbconc.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * created table for Employee
 */
@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmployeeId")
	private Long id;

	@NotNull(message = "name should not be null")
	@Size(min = 2, message = "Name atleast should have 2 characters")
	@Column(name = "EmployeeName")
	private String name;

	@NotNull(message = "company should not be null")
	@Size(min = 2, message = "Company atleast should have 2 characters")
	@Column(name = "EmployeeCompany")
	private String company;

	@NotNull(message = "country should not be null")
	@Size(min = 2, message = "Country atleast shoul have 2 characters")
	@Column(name = "EmployeeCountry")
	private String country;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeEntity")
	private AddressEntity addressentity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEntity")
	private List<ProjectEntity> projects = new ArrayList<>();

	public EmployeeEntity(String name, String company, String country, AddressEntity addressentity,
			List<ProjectEntity> projects) {
		this.name = name;
		this.company = company;
		this.country = country;
		this.addressentity = addressentity;
		this.projects = projects;
	}

	public EmployeeEntity() {

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

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void addProject(ProjectEntity project) {
		this.projects.add(project);
	}

	public void removeProject(ProjectEntity projects) {
		this.projects.remove(projects);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Employee{" + "id = " + this.id + "," + "name = " + this.name + "," + " company = " + this.company + ","
				+ "adress = " + this.addressentity.getHouseNumber() + ".}";
	}

}
