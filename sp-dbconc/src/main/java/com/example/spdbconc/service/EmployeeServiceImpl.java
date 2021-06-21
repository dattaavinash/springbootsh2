package com.example.spdbconc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.domain.repositories.ProjectRepository;

/*
 * @Service class files are used to write business logic in a different layer
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public List<EmployeeEntity> getEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeById(Long employeeEntity) {
		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(employeeEntity);

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			return employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity);
		}
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(employeeEntity.getId());

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			employeeEntityUpdate.setId(employeeEntity.getId());
			employeeEntityUpdate.setName(employeeEntity.getName());
			employeeEntityUpdate.setCompany(employeeEntity.getCompany());
			employeeEntityUpdate.setPhoneNumber(employeeEntity.getPhoneNumber());
			employeeEntityUpdate.setAddressentity(employeeEntity.getAddressentity());
			employeeRepository.save(employeeEntityUpdate);
			return employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity.getId());
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(id);

		if (employeeDb.isPresent()) {
			employeeRepository.delete(employeeDb.get());
			return "success";
		} else {
			throw new ResourceNotFoundException("record not found with id : " + id);
		}

	}

	public void addAddressForEmployee(AddressEntity addressEntity, Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			// addressRepository.save(addressEntity);
			EmployeeEntity employeeEntity = ee.get();
			employeeEntity.setAddressentity(addressEntity);
			//addressEntity.setEmployeeEntity(employeeEntity);
			employeeRepository.save(employeeEntity);
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}
	@Override
	public List<ProjectEntity> getProjects(String prjType, Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			List<ProjectEntity> pe = projectRepository.findEmployeeByProjectandtype(empId, prjType);
			return pe;
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}

	@Override
	public void createProjectForEmployee(List<ProjectEntity> projectEntities, Long empid) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empid);
		if (ee.isPresent()) {
			EmployeeEntity employeeEntity = ee.get();

			employeeEntity.setProjects(projectEntities);
			for (ProjectEntity projectEntity : projectEntities) {
				projectEntity.setEmployeeEntity(employeeEntity);
			}
			employeeRepository.save(employeeEntity);
		}
	}

	@Override
	public List<ProjectEntity> getProjectsForEmp(Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			List<ProjectEntity> pe = projectRepository.findEmployeeByProject(empId);
			return pe;
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}

}
