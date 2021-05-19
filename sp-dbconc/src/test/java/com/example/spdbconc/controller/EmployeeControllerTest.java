/*
 * package com.example.spdbconc.controller;
 * 
 * import static org.mockito.Mockito.when;
 * 
 * import java.awt.PageAttributes.MediaType; import java.util.Optional;
 * 
 * import org.junit.jupiter.api.DisplayName; import org.junit.jupiter.api.Test;
 * import org.junit.jupiter.api.extension.ExtendWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
 * import org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit.jupiter.SpringExtension; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.RequestBuilder;
 * 
 * import com.example.spdbconc.domain.Address; import
 * com.example.spdbconc.domain.Employee; import
 * com.example.spdbconc.domain.entities.EmployeeEntity; import
 * com.example.spdbconc.domain.repositories.EmployeeRepository; import
 * com.example.spdbconc.service.EmployeeService; import
 * com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
 * 
 * @ExtendWith(SpringExtension.class)
 * 
 * @SpringBootTest
 * 
 * @AutoConfigureMockMvc public class EmployeeControllerTest {
 * 
 * @Autowired private MockMvc mockmvc;
 * 
 * @MockBean private EmployeeService employeeService;
 * 
 * @MockBean private EmployeeRepository employeeRepository;
 * 
 * private static final String EMPLOYEE_ENTITY_URI = "/v1/";
 * 
 * @Test
 * 
 * @DisplayName("test for create employee") public void
 * testCreateEmployeeEntity() throws Exception {
 * when(employeeRepository.getEmployeeEntityById(id))
 * .thenReturn(Optional.of(new EmployeeEntity(id, name, company,
 * addressentity)));
 * 
 * String postRequestBody=getJsonFormat(getEmployeeEntity()) RequestBuilder
 * requestBuilder = post(EMPLOYEE_ENTITY_URI) .characterEncoding("UTF-8")
 * .contentType(MediaType.APPLICATION_JSON) .content(postRequestBody) } }
 */