package com.example.spdbconc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.validater.Phone;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmployeeModel {
	private Long empId;

	@NotNull(message = "name should not be null")
	@Size(min = 2, message = "Name atleast should have 2 characters")
	private String empName;

	@NotNull(message = "company should not be null")
	@Size(min = 2, message = "Company atleast should have 2 characters")
	private String empCompany;

	@NotBlank(message = "Enter a phone number")
	@Phone(message = "phone number is not valid")
	private String empPhoneNumber;

	private AddressEntity addressentity;

	List<ProjectEntity> projects = new ArrayList<>();

	public EmployeeModel(String empName, String empCompany, String empPhoneNumber,AddressEntity addressentity,List<ProjectEntity> projects) {
		this.empName = empName;
		this.empCompany = empCompany;
		this.empPhoneNumber = empPhoneNumber;
		this.addressentity=addressentity;
		this.projects=projects;
	}
}