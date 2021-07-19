package com.example.spdbconc.leave;

import org.springframework.stereotype.Component;

@Component
public class TaskTwo {
	public void executeStepTwo() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Leave request pending For Approval");
	}
}
