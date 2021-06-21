package com.example.spdbconc.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.spdbconc.domain.entities.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	@Query(value = "SELECT * FROM EMPLOYEE,PROJECT where Employee.EMPLOYEE_ID =PROJECT.EMP_ID  and PROJECT.PROJECT_TYPE =:type and EMPLOYEE.EMPLOYEE_ID=:empId", nativeQuery = true)
	List<ProjectEntity> findEmployeeByProjectandtype(Long empId, String type);
	
	@Query(value = "SELECT * FROM EMPLOYEE,PROJECT where Employee.EMPLOYEE_ID =PROJECT.EMP_ID and EMPLOYEE.EMPLOYEE_ID=:empId", nativeQuery = true)
	List<ProjectEntity> findEmployeeByProject(Long empId);
}
