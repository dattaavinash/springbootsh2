package com.example.spdbconc.domain.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.spdbconc.validater.Phone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * created table for Employee
 */
@Entity
@Table(name = "Employee")
@NoArgsConstructor
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmployeeId")
	@Getter
	@Setter
	private Long id;

	@NotNull(message = "name should not be null")
	@Size(min = 2, message = "Name atleast should have 2 characters")
	@Column(name = "EmployeeName")
	@Getter
	@Setter
	String name;

	@NotNull(message = "company should not be null")
	@Size(min = 2, message = "Company atleast should have 2 characters")
	@Column(name = "EmployeeCompany")
	@Getter
	@Setter
	String company;

	@NotBlank(message = "Enter a phone number")
	@Phone(message = "phone number is not valid")
	@Column(name = "EmployeePhoneNumber")
	@Getter
	@Setter
	String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "Housenumber", name = "Hno_id")
	@Getter
	@Setter
	AddressEntity addressentity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEntity")
	@Getter
	List<ProjectEntity> projects = new ArrayList<>();

	public EmployeeEntity(String name, String company, String phoneNumber, AddressEntity addressentity,
			List<ProjectEntity> projects) {
		this.name = name;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.addressentity = addressentity;
		this.projects = projects;
	}

	public void addProject(ProjectEntity projectEntity) {
		this.projects.add(projectEntity);
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}

	public void removeProject(ProjectEntity projects) {
		this.projects.remove(projects);
	}

	@Override
	public String toString() {
		return "Employee{" + "id = " + this.id + "," + "name = " + this.name + "," + " company = " + this.company + ","
				+ "adress = " + this.addressentity.getHouseNumber() + ".}";
	}

}
