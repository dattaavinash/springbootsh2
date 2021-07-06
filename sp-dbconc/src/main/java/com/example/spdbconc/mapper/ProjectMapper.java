package com.example.spdbconc.mapper;

import org.springframework.stereotype.Component;

import com.example.spdbconc.controller.ProjectModel;
import com.example.spdbconc.domain.entities.ProjectEntity;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
@Component
public class ProjectMapper extends ConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(ProjectModel.class, ProjectEntity.class)
		.field("prjId", "projectId")
		.field("prjName", "projectName")
		.field("prjType", "projectType")
		//.field("employeeEntity", "employeeEntity")
		.register();
	}
}
