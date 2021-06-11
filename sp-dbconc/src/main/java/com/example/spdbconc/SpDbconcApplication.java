package com.example.spdbconc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spdbconc.domain.Employee;
import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.ProjectEntity;
import com.example.spdbconc.domain.repositories.AddressRepository;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.domain.repositories.ProjectRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class SpDbconcApplication implements CommandLineRunner{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ProjectRepository projectRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(SpDbconcApplication.class, args);
	}

 
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
