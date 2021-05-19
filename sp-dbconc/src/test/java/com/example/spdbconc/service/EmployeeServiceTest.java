
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

	@Test
	@DisplayName("junit to test getEmployeeEnity")
	public void testGetEmployeeEntity() {
		EmployeeEntity widget1 = new EmployeeEntity(1l, "Widget Name", "Description", null);
		EmployeeEntity widget2 = new EmployeeEntity(2l, "Widget 2 Name", "Description 2", null);
		doReturn(Arrays.asList(widget1, widget2)).when(employeeRepository).findAll();

		// Execute the service call
		List<EmployeeEntity> widgets = employeeService.getEmployeeEntity();

		// Assert the response
		assertEquals(2, widgets.size());

	}
	@Test
	@DisplayName("junit to test getEmployeeEntityById")
	void testGetEmployeeEntityById() {
        // Setup our mock repository
        EmployeeEntity widget = new EmployeeEntity(1l, "Widget Name", "Description", null);
        doReturn(Optional.of(widget)).when(employeeRepository).findById(1l);

        // Execute the service call
        EmployeeEntity returnedWidget = employeeService.getEmployeeEntityById(1l);

        // Assert the response
        assertEquals(1l, returnedWidget.getId());
}
}
