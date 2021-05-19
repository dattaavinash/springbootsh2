package com.example.spdbconc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.service.EmployeeServiceImpl;

/**
 * RESTful web services using Spring MVC.
 * 
 */
@RestController
class EmployeeController {

	private EmployeeServiceImpl employeeServiceImpl;

	public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
		this.employeeServiceImpl = employeeServiceImpl;
	}

	/**
	 * 
	 * GET method 
	 * @return data from a server at the specified resource
	 */
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeEntity>> getEmployeeEntity() {
		return ResponseEntity.ok().body(employeeServiceImpl.getEmployeeEntity());
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeEntityById(@PathVariable long id) {
		return ResponseEntity.ok().body(employeeServiceImpl.getEmployeeEntityById(id));
		
	}
	
    /**
     * 
     * @param employeeEntity
     * create new subordinate resources
     */
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeEntity> createEmployeeEntity(@Valid @RequestBody EmployeeEntity employeeEntity) {
		return ResponseEntity.ok().body(this.employeeServiceImpl.createEmployeeEntity(employeeEntity));
	}
    
	/**
	 * 
	 * @param id
	 * @param employeeEntity
	 * call when you have to modify a single resource
	 */
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployeeEntity(@PathVariable long id,
			@Valid @RequestBody EmployeeEntity employeeEntity) {
		employeeEntity.setId(id);
		return ResponseEntity.ok().body(this.employeeServiceImpl.updateEmployeeEntity(employeeEntity));
	}
    
	/**
	 * 
	 * @param id
	 * The HTTP DELETE method is used to delete a resource from the server
	 */
	
	@DeleteMapping("/employee/{id}")
	public HttpStatus deleteEmployeeEntity(@PathVariable long id) {
		this.employeeServiceImpl.deleteEmployeeEntity(id);
		return HttpStatus.OK;
	}
}
