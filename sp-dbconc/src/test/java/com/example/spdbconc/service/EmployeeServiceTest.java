
package com.example.spdbconc.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	@DisplayName("junit to test createEmployeeEntity")
	public void testCreateEmployeeEntity() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(21L);
		employeeEntity.setName("athraya");
		employeeEntity.setCompany("dell");
		employeeEntity.setAddressentity(null);
		
		when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
		
		EmployeeEntity createdEmployeeEntity = employeeService.createEmployeeEntity(employeeEntity);
		
		assertEquals(createdEmployeeEntity.getId(), employeeEntity.getId());
		assertEquals(createdEmployeeEntity.getName(), employeeEntity.getName());
		assertEquals(createdEmployeeEntity.getCompany(), employeeEntity.getCompany());
	}
}
