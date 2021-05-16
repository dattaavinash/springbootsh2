package com.example.spdbconc.service;

import java.util.List;

import com.example.spdbconc.domain.entities.EmployeeEntity;

public interface EmployeeService {
	EmployeeEntity createEmployeeEntity(EmployeeEntity employeeEntity);

	EmployeeEntity updateEmployeeEntity(EmployeeEntity employeeEntity);

	List<EmployeeEntity> getEmployeeEntity();

	EmployeeEntity getEmployeeEntityById(Long employeeEntity);

	void deleteEmployeeEntity(Long id);

}
