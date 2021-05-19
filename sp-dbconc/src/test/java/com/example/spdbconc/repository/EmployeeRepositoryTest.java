package com.example.spdbconc.repository;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)

@DataJpaTest

@DisplayName("testing employee repository")

public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	@Sql(scripts="classpath:create-test-data.sql", executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts="classpath:cleanup-test-data.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test findById")
	void testGetEmployeeEntityById() {
		Optional<EmployeeEntity> eeOptional=employeeRepository.findById(23L);
		assertThat(eeOptional.isPresent()).isTrue();
		EmployeeEntity ee=eeOptional.get();
		assertThat(ee.getId()).isEqualTo(23L);
	}
	
	@Test
	@DisplayName("testing when Id not found")
	void testGetEmployeeEntityById_NotFound() {
		Optional<EmployeeEntity> eeOptional=employeeRepository.findById(23L);
		assertThat(eeOptional.isPresent()).isFalse();
	}
	
	@Test
	@Sql(scripts="classpath:create-test-data.sql", executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts="classpath:cleanup-test-data.sql", executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test Save Id")
	void testSaveEmployeeEntity() {
		EmployeeEntity employeeEntity =createEmployeeEntity();
		employeeRepository.save(employeeEntity);
		Optional<EmployeeEntity> eeOptional=employeeRepository.findById(22l);
		assertThat(eeOptional.isPresent()).isTrue();
	}
	
	private EmployeeEntity createEmployeeEntity() {
		EmployeeEntity ee = new EmployeeEntity(22L,"tcs","ram",null);
		return ee;
	}
	
	/*
	 * @Test
	 * 
	 * @Sql(scripts="classpath:create-test-data.sql",
	 * executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
	 * 
	 * @Sql(scripts="classpath:cleanup-test-data.sql",
	 * executionPhase=ExecutionPhase.AFTER_TEST_METHOD)
	 * 
	 * @DisplayName("test update Id") void testUpdateEmployeeEntity() {
	 * employeeRepository.updateEmployeeEntity() }
	 */
}
