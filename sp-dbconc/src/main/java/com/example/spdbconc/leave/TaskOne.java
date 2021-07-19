package com.example.spdbconc.leave;

import org.springframework.stereotype.Component;

import com.example.spdbconc.domain.entities.LeaveEntity;
import com.example.spdbconc.domain.repositories.LeaveRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TaskOne {
	
	   
	private final LeaveRepository leaveRepository;
	
	public void executeStepOne(Long id,LeaveEntity leaveEntity) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
			leaveRepository.save(leaveEntity);
		System.out.println("Leave Request Created for employee: "+id);
	}
}

