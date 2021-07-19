package com.example.spdbconc.leave;

import org.springframework.stereotype.Component;

@Component
public class TaskThree {
	public void executeStepThree() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Leave request Approved");
	}
}
