
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

	/*
	 * J unit for post method.
	 */
	@Test
	@DisplayName("junit to test createEmployeeEntity")
	public void testCreateEmployee() {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setId(21L);
		employeeEntity.setName("athraya");
		employeeEntity.setPhoneNumber("9505315346");
		employeeEntity.setAddressentity(null);

		when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);

		EmployeeEntity createdEmployeeEntity = employeeService.createEmployee(employeeEntity);

		assertEquals(createdEmployeeEntity.getId(), employeeEntity.getId());
		assertEquals(createdEmployeeEntity.getName(), employeeEntity.getName());
		assertEquals(createdEmployeeEntity.getPhoneNumber(), employeeEntity.getPhoneNumber());
	}

	/*
	 * J unit for get method.
	 */
	@Test
	@DisplayName("junit to test getEmployeeEnity")
	public void testGetEmployee() {
		EmployeeEntity employee1 = new EmployeeEntity("avi", "tcs", "india",null, null);
		EmployeeEntity employee2 = new EmployeeEntity("viswa", "Description 2", null,null, null);
		doReturn(Arrays.asList(employee1, employee2)).when(employeeRepository).findAll();

		List<EmployeeEntity> employeeEntities = employeeService.getEmployee();
		assertEquals(2, employeeEntities.size());

	}

	/*
	 * J unit for get by Id method.
	 */
	@Test
	@DisplayName("junit to test getEmployeeEntityById")
	void testGetEmployeeById() {
		EmployeeEntity employee = new EmployeeEntity("avi", "tcs", "rome",null, null);
		doReturn(Optional.of(employee)).when(employeeRepository).findById(null);

		EmployeeEntity employeeEntity = employeeService.getEmployeeById(null);

		assertEquals(null, employeeEntity.getId());
	}
 
	/*
	 * J unit for put method.
	 */
	@Test
	@DisplayName("junit to test putEmployeeEntityB")
	void testPutEmployee() {
		EmployeeEntity employee = new EmployeeEntity("ram", "hp", "italy",null, null);
		employee.setName("beard");
		employee.setCompany("dell");
		employee.setAddressentity(null);
		doReturn(Optional.of(employee)).when(employeeRepository).findById(null);

		EmployeeEntity employeeEntity = employeeService.updateEmployee(employee);

		assertEquals("beard", employeeEntity.getName());
	}

	/*
	 * J unit for delete method.
	 */
	@Test
	public void testDeleteStudent() {
		EmployeeEntity employeeEntity = new EmployeeEntity("avi", "ghd", "france",null, null);
		doReturn(Optional.of(employeeEntity)).when(employeeRepository).findById(3L);
		String ee = employeeService.deleteEmployee(3L);
		assertEquals("success", ee);
	}
}
