package com.example.spdbconc.mapper;

import org.springframework.stereotype.Component;

import com.example.spdbconc.controller.EmployeeModel;
import com.example.spdbconc.domain.entities.EmployeeEntity;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class EmployeeMapper extends ConfigurableMapper{
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(EmployeeModel.class, EmployeeEntity.class)
		       .field("empId","id")
		       .field("empName","name")
		       .field("empCompany","company")
		       .field("empPhoneNumber","phoneNumber")
		       .field("addressentity", "addressentity")
		       .field("projects", "projects")
		       .register();
	}
}

