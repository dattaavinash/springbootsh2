
package com.example.spdbconc.controller;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static com.example.spdbconc.controller.JsonFormat.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.mapper.EmployeeMapper;
import com.example.spdbconc.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;

@ExtendWith(SpringExtension.class)

@SpringBootTest

@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockmvc;

	@MockBean
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Autowired
	@MockBean
	private EmployeeMapper employeeMapper;

	@Captor
	private ArgumentCaptor<Long> idCaptor;

	@Captor
	private ArgumentCaptor<EmployeeEntity> employeeCaptor;

	@Test

	@DisplayName("test for get method")
	public void testGetEmployee() throws Exception {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		String getRequestBody = getJsonFormat(employeeEntity);
		Mockito.when(employeeService.getEmployeeById(anyLong())).thenReturn(employeeEntity);

		RequestBuilder requestBuilder = get("/employees/10").accept(MediaType.APPLICATION_JSON);
		mockmvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content().json(getRequestBody));

		verify(employeeService, atLeast(1)).getEmployeeById(idCaptor.capture());
		assertEquals(10, idCaptor.getValue());
	}

	
	/*
	 * @Test
	 * 
	 * @DisplayName("test for post method") public void testCreateEmployee() throws
	 * Exception { EmployeeModel employeeModel = new EmployeeModel("avi", "tcs",
	 * "9505315346", null, null); //Mockito.when(employeeMapper.map(employeeModel,
	 * EmployeeEntity.class)).thenReturn(null); EmployeeEntity e1=
	 * employeeMapper.map(employeeModel, EmployeeEntity.class);
	 * Mockito.when(employeeService.createEmployee(any())).thenReturn(e1);
	 * 
	 * String postRequestBody = getJsonFormat(e1); RequestBuilder requestBuilder =
	 * post("/employees").characterEncoding("UTF-8")
	 * .contentType(MediaType.APPLICATION_JSON).content(postRequestBody);
	 * mockmvc.perform(requestBuilder).andExpect(status().isOk()).andExpect(content(
	 * ).json(postRequestBody)); verify(employeeService,
	 * times(1)).createEmployee(any());
	 * 
	 * //assertEquals("avi", employeeCaptor.getValue().getName());
	 * //assertEquals("tcs", employeeCaptor.getValue().getCompany());
	 * //assertEquals("9505315346", employeeCaptor.getValue().getPhoneNumber());
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @DisplayName("test for update method") public void testUpdateEmployee()
	 * throws Exception { EmployeeEntity employeeEntity = new EmployeeEntity("avi",
	 * "tcs", "9505315346", null, null); employeeEntity.setName("viswa");
	 * employeeEntity.setCompany("dell"); // employeeEntity.setCountry("rome");
	 * Mockito.when(employeeService.updateEmployee(any())).thenReturn(employeeEntity
	 * ); String putRequestBody = getJsonFormat(employeeEntity); RequestBuilder
	 * requestBuilder = put("/employees/4").characterEncoding("UTF-8")
	 * .contentType(MediaType.APPLICATION_JSON).content(putRequestBody);
	 * mockmvc.perform(requestBuilder).andExpect(status().isOk());
	 * verify(employeeService, times(1)).updateEmployee(any());
	 * assertEquals("viswa", employeeCaptor.getValue().getName());
	 * assertEquals("dell", employeeCaptor.getValue().getCompany());
	 * assertEquals("9505315346", employeeCaptor.getValue().getPhoneNumber()); }
	 */	 
	@Test

	@DisplayName("test for delete method")
	public void testDeleteMethod() throws Exception {
		EmployeeEntity employeeEntity = new EmployeeEntity("avi", "tcs", "9505315346", null, null, null);
		Mockito.when(employeeService.deleteEmployee(anyLong())).thenReturn("success");

		String deleteRequestBody = getJsonFormat(employeeEntity);
		RequestBuilder requestBuilder = delete("/employees/10").characterEncoding("UTF-8")
				.contentType(MediaType.APPLICATION_JSON).content(deleteRequestBody);
		mockmvc.perform(requestBuilder).andExpect(status().isOk());
		verify(employeeService, times(1)).deleteEmployee(idCaptor.capture());
		assertEquals(10, idCaptor.getValue());
	}
}
