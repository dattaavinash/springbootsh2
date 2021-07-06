package com.example.spdbconc.mapper;

import org.springframework.stereotype.Component;

import com.example.spdbconc.controller.AddressModel;
import com.example.spdbconc.domain.entities.AddressEntity;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class AddressMapper extends ConfigurableMapper {
@Override
protected void configure(MapperFactory factory) {
	
	factory.classMap(AddressModel.class, AddressEntity.class)
	.field("addHouseNumber", "houseNumber")
	.field("addStreetName", "streetName")
	.field("addCity", "city")
	.register();
}
}
