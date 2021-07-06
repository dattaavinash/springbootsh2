package com.example.spdbconc.controller;

import com.example.spdbconc.domain.entities.EmployeeEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProjectModel {

	private Long prjId;

	private String prjName;

	private String prjType;
   
	private EmployeeEntity employeeEntity;
	

}
