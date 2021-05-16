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
}
