package com.example.spdbconc.service;

import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.spdbconc.domain.entities.EmployeeEntity;
import com.example.spdbconc.domain.entities.LeaveEntity;
import com.example.spdbconc.domain.repositories.EmployeeRepository;
import com.example.spdbconc.leave.TaskOne;
import com.example.spdbconc.leave.TaskThree;
import com.example.spdbconc.leave.TaskTwo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LeaveWorkFlowService {

	private final TaskOne taskOne;

	private final TaskTwo taskTwo;

	private final TaskThree taskThree;
	
	private final EmployeeRepository employeeRepository;


	@Async
	public void initiateRequest(Long id, LeaveEntity leaveEntity) {
		System.out.println("Leave request creation is in progress");
		Optional<EmployeeEntity> empId = employeeRepository.findById(id);
		if (empId.isPresent()) {
		taskOne.executeStepOne(id,leaveEntity);
		taskTwo.executeStepTwo();
		taskThree.executeStepThree();
		}
	}
	}

