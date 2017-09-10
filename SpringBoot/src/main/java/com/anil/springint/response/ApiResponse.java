package com.anil.springint.response;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.anil.springint.constants.IntegrationConstant;

@Component
public class ApiResponse {

	@ServiceActivator(inputChannel = IntegrationConstant.HTTP_RESPONSE_CHANNEL)
	public String prcoessReponse(Message<?> message) {
		System.out.println("Inside Http Response Process");
		return (String) message.getPayload();
	}

}
