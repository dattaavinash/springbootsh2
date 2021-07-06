
package com.example.spdbconc.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.spdbconc.controller.EmployeeModel;
import com.example.spdbconc.controller.ProjectModel;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.mapper.EmployeeMapper;

import ma.glasnost.orika.MapperFacade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	
	  @Autowired
	  private EmployeeMapper employeeMapper;
	 
	

	/*
	 * public EmployeeServiceTest(EmployeeMapper employeeMapper) {
	 * this.employeeMapper = employeeMapper; }
	 * 
	 */	/*
	 * J unit for post method.
	 */

	@Test

	@DisplayName("junit to test createEmployeeEntity")
	public void testCreateEmployee() {
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setEmpId(21L);
		employeeModel.setEmpName("athraya");
		employeeModel.setEmpPhoneNumber("9505315346");
		//EmployeeMapper employeeMapper = mock(EmployeeMapper.class);
		//ArgumentCaptor<EmployeeMapper> valueCapture = ArgumentCaptor.forClass(EmployeeMapper.class);
		//doNothing().when(employeeMapper.map(EmployeeEntity.class, EmployeeModel.class),valueCapture;
		// valueCapture.capture();
		EmployeeEntity e1 = employeeMapper.map(employeeModel, EmployeeEntity.class);

		EmployeeEntity createdEmployeeEntity = employeeService.createEmployee(employeeModel);
		when(employeeRepository.save(e1)).thenReturn(e1);

		assertEquals(createdEmployeeEntity.getId(), e1.getId());
		assertEquals(createdEmployeeEntity.getName(), e1.getName());
		assertEquals(createdEmployeeEntity.getPhoneNumber(), e1.getPhoneNumber());
	}

	/*
	 * J unit for get method.
	 */
	@Test

	@DisplayName("junit to test getEmployeeEnity")
	public void testGetEmployee() {
		EmployeeEntity employee1 = new EmployeeEntity("avi", "tcs", "india", null, null, null);
		EmployeeEntity employee2 = new EmployeeEntity("viswa", "Description 2", null, null, null, null);
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
		EmployeeEntity employee = new EmployeeEntity("avi", "tcs", "rome", null, null, null);
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
		EmployeeModel employee = new EmployeeModel();
		employee.setEmpName("beard");
		employee.setEmpCompany("dell");
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
		EmployeeEntity employeeEntity = new EmployeeEntity("avi", "ghd", "france", null, null, null);
		doReturn(Optional.of(employeeEntity)).when(employeeRepository).findById(3L);
		String ee = employeeService.deleteEmployee(3L);
		assertEquals("success", ee);
	}
}
