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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

/**
 * RESTful web services using Spring MVC.
 * 
 */
@RestController
@RequestMapping("/employees")
@Slf4j
class EmployeeController {
	     
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	

	
	@GetMapping("/logger")
	public String index() {
		log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
 

        return "Check out the Logs to see the output...";
    }

	/**
	 * Create Employee
	 * 
	 * @param employeeEntity create new subordinate resources
	 * @throws Exception 
	 */
	@PostMapping
	public ResponseEntity<EmployeeEntity> createEmployee(@Valid @RequestBody EmployeeModel employeeModel) throws Exception {
		log.info("Post method is accessed");
		return new ResponseEntity<>(employeeService.createEmployee(employeeModel), HttpStatus.CREATED);

	}

	/**
	 * Retrieves Employee
	 * 
	 * @return data from a server at the specified resource
	 */
	@GetMapping
	public List<EmployeeEntity> getEmployee() {
		log.info("Get method is accessed");
		//BankDetails bankDetails = myFeignClient.getBankDetails();
		return employeeService.getEmployee();
				}

	/**
	 * Retrieves Employee by Employee Id
	 * 
	 * @return data from a server at the specified resource
	 */
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable long id) {
		log.info("GetById Method is accessed");
		return ResponseEntity.ok().body(employeeService.getEmployeeById(id));

	}

	/**
	 * Updates Employee by Employee Id
	 * 
	 * @param id
	 * @param employeeEntity call when you have to modify a single resource
	 */
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable long id,
			@Valid @RequestBody EmployeeModel employeeModel) {
		employeeModel.setEmpId(id);
		log.info("Put method is accessed");
		return ResponseEntity.ok().body(employeeService.updateEmployee(employeeModel));
	}

	/**
	 * Deletes Employee by Id
	 * 
	 * @param id The HTTP DELETE method is used to delete a resource from the server
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable long id) {
		log.info("Delete method is accessed");
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Add address for Employee
	 * 
	 * @param Adds address sub resource for Employee resource
	 */
	@PostMapping("/{empid}/address")
	public ResponseEntity<EmployeeEntity> addAddressForEmployee(@PathVariable("empid") Long empId,
			@RequestBody AddressModel addressModel) {
		log.info("Post method is accessed to add address for employee");
		employeeService.addAddressForEmployee(addressModel, empId);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	/**
	 * Add projects for Employee
	 * 
	 * @param Adds project sub resource for Employee resource
	 */
	@PostMapping("/{empid}/projects")
	public ResponseEntity<List<ProjectEntity>> createProjectForEmployee(@Valid @RequestBody List<ProjectModel> projectModels,
			@PathVariable Long empid) {
		log.info("Post method is accessed to add projects for employee");
		employeeService.createProjectForEmployee(projectModels,empid);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/{empid}/projects")
	public ResponseEntity<List<ProjectEntity>> getProjectsForEmp(
			@PathVariable("empid") Long empId) {
		log.info("Get method is accessed to get projects for employee");
		return ResponseEntity.ok().body(employeeService.getProjectsForEmp(empId));
	}
	/**
	 * Retrieves primary project of Employee
	 * 
	 * @return data from a server at the specified resource
	 */
	@GetMapping("/{empid}/project")
	public ResponseEntity<List<ProjectEntity>> getProjects(@RequestParam("projectType") String prjType,
			@PathVariable("empid") Long empId) {
		log.info("Get method is accessed to get projects of employee");
		return ResponseEntity.ok().body(employeeService.getProjects(prjType, empId));
	}
}
