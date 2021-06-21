package com.example.spdbconc.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "project")
@NoArgsConstructor
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	@Getter
	@Setter
	private Long projectId;

	@Column(name = "Project_name")
	@Getter
	@Setter
	private String projectName;

	@Column(name = "project_type")
	@Getter
	@Setter
	private String projectType;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "EmployeeId", name = "emp_id")
	@Getter
	@Setter
	private EmployeeEntity employeeEntity;

	public ProjectEntity(Long projectId, String projectName, String projectType, EmployeeEntity employeeEntity) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectType = projectType;
		this.employeeEntity = employeeEntity;
	}
}
