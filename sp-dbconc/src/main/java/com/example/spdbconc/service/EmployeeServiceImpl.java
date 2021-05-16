package com.example.spdbconc.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;

/*
 * @Service class files are used to write business logic in a different layer
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeEntity createEmployeeEntity(EmployeeEntity employeeEntity) {
		return employeeRepository.save(employeeEntity);
	}

	@Override
	public EmployeeEntity updateEmployeeEntity(EmployeeEntity employeeEntity) {
		Optional<EmployeeEntity> employeeDb = this.employeeRepository.findById(employeeEntity.getId());

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			employeeEntityUpdate.setId(employeeEntity.getId());
			employeeEntityUpdate.setName(employeeEntity.getName());
			employeeEntityUpdate.setCompany(employeeEntity.getCompany());
			employeeEntityUpdate.setAddressentity(employeeEntity.getAddressentity());
			employeeRepository.save(employeeEntityUpdate);
			return employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity.getId());
		}
	}

	@Override
	public List<EmployeeEntity> getEmployeeEntity() {
		return this.employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeEntityById(Long employeeEntity) {
		Optional<EmployeeEntity> employeeDb = this.employeeRepository.findById(employeeEntity);

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			return employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity);
		}
	}

	@Override
	public void deleteEmployeeEntity(Long id) {
		Optional<EmployeeEntity> employeeDb = this.employeeRepository.findById(id);

		if (employeeDb.isPresent()) {
			this.employeeRepository.delete(employeeDb.get());
		} else {
			throw new ResourceNotFoundException("record not found with id : " + id);
		}

	}

}
