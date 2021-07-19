package com.example.spdbconc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spdbconc.domain.entities.LeaveEntity;
import com.example.spdbconc.service.LeaveWorkFlowService;

@RestController
@RequestMapping("/leave-request/{empId}")
public class LeaveController {

	@Autowired
	private LeaveWorkFlowService leaveWorkFlowService;

	@PostMapping()
	public ResponseEntity<String> leaveDetails(@PathVariable("empId") Long id, @RequestBody LeaveEntity leaveEntity) {
		leaveWorkFlowService.initiateRequest(id, leaveEntity);
		return new ResponseEntity<String>("Leave Request Initiated", HttpStatus.ACCEPTED);
	}
}
