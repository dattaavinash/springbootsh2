package com.example.spdbconc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.spdbconc.domain.Employee;
import com.example.spdbconc.domain.entities.AddressEntity;
import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.repositories.AddressRepository;
import com.example.spdbconc.domain.repositories.EmployeeRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class SpDbconcApplication implements CommandLineRunner {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private AddressRepository addressRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpDbconcApplication.class, args);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void run(String... args) throws Exception {

		AddressEntity ab = new AddressEntity();
		ab.setHouseNumber(15L);
		ab.setStreetName("dollars street");
		ab.setCity("Mumbai");
		ab.setCountry("India");

		AddressEntity ab1 = new AddressEntity();
		ab1.setHouseNumber(20L);
		ab1.setStreetName("money street");
		ab1.setCity("Delhi");
		ab1.setCountry("India");

		AddressEntity ab2 = new AddressEntity();
		ab2.setHouseNumber(30L);
		ab2.setStreetName("dirhams street");
		ab2.setCity("qatar");
		ab2.setCountry("Dubai");

		
		  addressRepository.save(ab); 
		  addressRepository.save(ab1);
		  addressRepository.save(ab2);
		 

		EmployeeEntity sc = new EmployeeEntity();
		sc.setId(1L);
		sc.setName("Avinash");
		sc.setCompany("tcs");
		sc.setAddressentity(ab);

		EmployeeEntity sc1 = new EmployeeEntity();
		sc1.setId(2L);
		sc1.setName("Anikit");
		sc1.setCompany("hcl");
		sc1.getAddressentity();
		sc1.setAddressentity(ab1);

		EmployeeEntity sc2 = new EmployeeEntity();
		sc2.setId(3L);
		sc2.setName("Vishwa");
		sc2.setCompany("infy");
		sc2.setAddressentity(ab2);

		employeeRepository.save(sc);
		employeeRepository.save(sc1);
		employeeRepository.save(sc2);
		System.out.println(addressRepository.count());
		System.out.println(employeeRepository.equals(sc1.getName().equalsIgnoreCase(sc2.getName())));
		for (EmployeeEntity e : this.employeeRepository.findAll()) {
			System.out.println(e.toString());
		}

	}

}
