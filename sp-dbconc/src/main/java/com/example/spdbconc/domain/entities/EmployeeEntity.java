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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/*
 * created table for Employee
 */
@Entity
@Table(name = "Employee")
@NoArgsConstructor
@Getter
@Setter
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmployeeId")
	private Long id;

	@Column(name = "EmployeeName")
	String name;

	@Column(name = "EmployeeCompany")
	String company;

	@Column(name = "EmployeePhoneNumber")
	String phoneNumber;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "Housenumber", name = "Hno_id")
	private AddressEntity addressentity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeEntity")
	List<ProjectEntity> projects = new ArrayList<>();
	
	private BankDetails bankdetails;

	public EmployeeEntity(String name, String company, String phoneNumber, AddressEntity addressentity,
			List<ProjectEntity> projects,BankDetails bankDetails) {
		this.name = name;
		this.company = company;
		this.phoneNumber = phoneNumber;
		this.addressentity = addressentity;
		this.projects = projects;
		this.bankdetails=bankDetails;
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
				+ " PhoneNumber = " + this.phoneNumber + "}";
	}

}
