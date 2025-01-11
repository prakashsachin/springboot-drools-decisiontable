package com.drools.example.controller;

import com.drools.example.model.EligibilityResponse;
import com.drools.example.model.EmployeeData;
import org.kie.api.runtime.KieSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	private final KieSession session;

	public EmployeeController(KieSession session) {
		this.session = session;
	}

	@PostMapping("/eligibleRoles")
	public EligibilityResponse getEligibility(@RequestBody EmployeeData data) {
		EligibilityResponse eligibilityResponse = new EligibilityResponse();
		session.setGlobal("eligibilityResponse", eligibilityResponse);
		session.insert(data);
		session.insert(eligibilityResponse);
		int i = session.fireAllRules();
		System.out.println("Total rules executed : " + i);
		return eligibilityResponse;
	}

}
