package com.customer.service.com.customer.serviceApp.actuatorCustomeEnfpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="customeActuator")
public class CustomeActuator {
	@ReadOperation
	public String currentDBdetails() {
		return "Give current DB status of recent interaction of the app";
	}

}
