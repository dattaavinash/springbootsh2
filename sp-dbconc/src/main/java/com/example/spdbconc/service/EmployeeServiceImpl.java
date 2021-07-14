package com.example.spdbconc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import com.example.spdbconc.controller.AddressModel;
import com.example.spdbconc.controller.EmployeeModel;
import com.example.spdbconc.controller.ProjectModel;
import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.domain.repositories.ProjectRepository;
import com.example.spdbconc.exceptionHandilng.YourException;
import com.example.spdbconc.mapper.AddressMapper;
import com.example.spdbconc.mapper.EmployeeMapper;
import com.example.spdbconc.mapper.ProjectMapper;

/*
 * @Service class files are used to write business logic in a different layer
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	private ProjectRepository projectRepository;

	private EmployeeMapper employeeMapper;

	private AddressMapper addressMapper;

	private ProjectMapper projectMapper;
	
	private MyFeignClient myFeignClient;
	
	private int count=0;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
			EmployeeMapper employeeMapper, AddressMapper addressMapper, ProjectMapper projectMapper,MyFeignClient myFeignClient) {
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
		this.employeeMapper = employeeMapper;
		this.addressMapper = addressMapper;
		this.projectMapper = projectMapper;
		this.myFeignClient=  myFeignClient;
	}

	@Override
	@Retryable(value = RuntimeException.class,maxAttempts = 4)
	public EmployeeEntity createEmployee(EmployeeModel employeeModel)  {
		count++;
		System.out.println("trying to call feign client");
		if(count==4)
		{
			throw new YourException("unable to call after three attempts");
		}
		else
		{
		EmployeeEntity employeeEntity = employeeMapper.map(employeeModel, EmployeeEntity.class);
		List<ProjectEntity> projectEntities = employeeEntity.getProjects();
		AddressEntity addressEntity = employeeEntity.getAddressentity();
		employeeEntity.setProjects(projectEntities);
		employeeEntity.setAddressentity(addressEntity);
		if (addressEntity != null) {
			addressEntity.setEmployeeEntity(employeeEntity);
		}
		if (projectEntities != null) {
			for (ProjectEntity projectEntity : projectEntities) {
				projectEntity.setEmployeeEntity(employeeEntity);
			}
		}
		try {
		  String bankDetails = myFeignClient.getBankDetails();
		  employeeEntity.setBankdetails(bankDetails);
		}
		catch (Exception e) {
			throw new YourException("unable to call the Rest Api feign client", e);
			}  
		return employeeRepository.save(employeeEntity);
		
		}
		}
	
	//@Override
	@Recover
	public String recover() {
		return "try after sometime";
	}
	
	@Override
	public List<EmployeeEntity> getEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public EmployeeEntity getEmployeeById(Long employeeEntity) {
		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(employeeEntity);

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			//BankDetails bankDetails = myFeignClient.getBankDetails();
			return  employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity);
		}
	}

	@Override
	public EmployeeEntity updateEmployee(EmployeeModel employeeModel) {
		EmployeeEntity employeeEntity = employeeMapper.map(employeeModel, EmployeeEntity.class);

		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(employeeEntity.getId());

		if (employeeDb.isPresent()) {
			EmployeeEntity employeeEntityUpdate = employeeDb.get();
			employeeEntityUpdate.setId(employeeEntity.getId());
			employeeEntityUpdate.setName(employeeEntity.getName());
			employeeEntityUpdate.setCompany(employeeEntity.getCompany());
			employeeEntityUpdate.setPhoneNumber(employeeEntityUpdate.getPhoneNumber());
			List<ProjectEntity> projectEntities = employeeEntity.getProjects();
			AddressEntity addressEntity = employeeEntity.getAddressentity();
			employeeEntityUpdate.setProjects(projectEntities);
			employeeEntityUpdate.setAddressentity(addressEntity);
			if (addressEntity != null) {
				addressEntity.setEmployeeEntity(employeeEntityUpdate);
			}
			for (ProjectEntity projectEntity : projectEntities) {
				projectEntity.setEmployeeEntity(employeeEntityUpdate);
			}
			employeeRepository.save(employeeEntityUpdate);
			return employeeEntityUpdate;
		} else {
			throw new ResourceNotFoundException("record not found with id : " + employeeEntity.getId());
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		Optional<EmployeeEntity> employeeDb = employeeRepository.findById(id);

		if (employeeDb.isPresent()) {
			employeeRepository.delete(employeeDb.get());
			return "success";
		} else {
			throw new ResourceNotFoundException("record not found with id : " + id);
		}

	}

	public void addAddressForEmployee(AddressModel addressModel, Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			AddressEntity addressEntity = addressMapper.map(addressModel, AddressEntity.class);

			// addressRepository.save(addressEntity);
			EmployeeEntity employeeEntity = ee.get();
			employeeEntity.setAddressentity(addressEntity);
			// addressEntity.setEmployeeEntity(employeeEntity);
			employeeRepository.save(employeeEntity);
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}

	@Override
	public List<ProjectEntity> getProjects(String prjType, Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			List<ProjectEntity> pe = projectRepository.findEmployeeByProjectandtype(empId, prjType);
			return pe;
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}

	@Override
	public void createProjectForEmployee(List<ProjectModel> projectModels, Long empid) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empid);
		if (ee.isPresent()) {
			List<ProjectEntity> projectEntities = projectMapper.mapAsList(projectModels, ProjectEntity.class);
			EmployeeEntity employeeEntity = ee.get();

			employeeEntity.setProjects(projectEntities);
			for (ProjectEntity projectEntity : projectEntities) {
				projectEntity.setEmployeeEntity(employeeEntity);
			}
			employeeRepository.save(employeeEntity);
		}
	}

	@Override
	public List<ProjectEntity> getProjectsForEmp(Long empId) {
		Optional<EmployeeEntity> ee = employeeRepository.findById(empId);
		if (ee.isPresent()) {
			List<ProjectEntity> pe = projectRepository.findEmployeeByProject(empId);
			return pe;
		} else {
			throw new ResourceNotFoundException("record not found with: " + empId);
		}
	}

}
