package com.example.spdbconc.service;

import java.util.List;

import org.springframework.retry.annotation.Recover;
import org.springframework.stereotype.Service;

import com.example.spdbconc.controller.AddressModel;
import com.example.spdbconc.controller.EmployeeModel;
import com.example.spdbconc.controller.ProjectModel;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;

@Service
public interface EmployeeService {
	EmployeeEntity createEmployee(EmployeeModel employeeModel) throws Exception;

	EmployeeEntity updateEmployee(EmployeeModel employeeModel);

	List<EmployeeEntity> getEmployee();

	EmployeeEntity getEmployeeById(Long employeeEntity);

	String deleteEmployee(Long id);
	
	@Recover
	public String recover();
	
	void addAddressForEmployee(AddressModel addressModel,Long empId);

	List<ProjectEntity> getProjects(String prjType, Long prjId);

	void createProjectForEmployee(List<ProjectModel> projectModels, Long empid);
	
	List<ProjectEntity> getProjectsForEmp(Long empId);


}
