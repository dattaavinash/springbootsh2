package com.example.spdbconc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;

@Service
public interface EmployeeService {
	EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

	EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);

	List<EmployeeEntity> getEmployee();

	EmployeeEntity getEmployeeById(Long employeeEntity);

	String deleteEmployee(Long id);
	
	void addAddressForEmployee(AddressEntity addressEntity,Long empId);

	List<ProjectEntity> getProjects(String prjType, Long prjId);

	void createProjectForEmployee(List<ProjectEntity> projectEntities, Long empid);
	
	List<ProjectEntity> getProjectsForEmp(Long empId);


}
