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

	/*
	 * J unit test for get method
	 */
	@Test
	@Sql(scripts = "classpath:create-test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "classpath:cleanup-test-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test findById")
	void testGetEmployeeById() {
		Optional<EmployeeEntity> eeOptional = employeeRepository.findById(23L);
		assertThat(eeOptional.isPresent()).isTrue();
		EmployeeEntity ee = eeOptional.get();
		assertThat(ee.getId()).isEqualTo(23L);
	}

	@Test
	@DisplayName("testing when Id not found")
	void testGetEmployeeById_NotFound() {
		Optional<EmployeeEntity> eeOptional = employeeRepository.findById(23L);
		assertThat(eeOptional.isPresent()).isFalse();
	}

	/*
	 * J unit test for post method
	 */
	@Test
	@Sql(scripts = "classpath:create-test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "classpath:cleanup-test-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test Save Id")
	void testSaveEmployee() {
		EmployeeEntity employeeEntity = createEmployee();
		employeeRepository.save(employeeEntity);
		Optional<EmployeeEntity> eeOptional = employeeRepository.findByName("tcs");
		assertThat(eeOptional.isPresent()).isTrue();
	}

	private EmployeeEntity createEmployee() {
		EmployeeEntity ee = new EmployeeEntity("tcs", "ram", "9505315346",null,null, null); 
		return ee;
	}

	/*
	 * J unit test for put method
	 */
	@Test
	@Sql(scripts = "classpath:create-test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "classpath:cleanup-test-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test update Id")
	void testUpdateEmployee() {
		EmployeeEntity employeeEntity = createEmployee();
		employeeEntity.setName("alok");
		employeeEntity.setCompany("vlos");
		employeeEntity.setAddressentity(null);
		employeeRepository.save(employeeEntity);
		Optional<EmployeeEntity> eeOptional = employeeRepository.findByName("alok");
		assertThat(eeOptional.isPresent()).isTrue();
		EmployeeEntity ee = eeOptional.get();
		assertThat(ee.getId()).isEqualTo(2L);
	}


	/*
	 * J unit test for delete method
	 */
	@Test
	@Sql(scripts = "classpath:create-test-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "classpath:cleanup-test-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	@DisplayName("test delete Id")
	void testDeleteEmployee() {
		EmployeeEntity ee = createEmployee();
		employeeRepository.delete(ee);
		Optional<EmployeeEntity> eeOptional = employeeRepository.findByName("tcs");
		assertThat(eeOptional.isPresent()).isFalse();
	}
}
