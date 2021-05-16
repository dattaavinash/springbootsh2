package com.example.spdbconc.domain.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spdbconc.domain.Employee;
import com.example.spdbconc.domain.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity save(Employee newEmployee);

	Optional<EmployeeEntity> getEmployeeEntityById(long l);

}
