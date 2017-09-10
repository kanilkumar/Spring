package com.anil.springint.request;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.anil.springint.constants.IntegrationConstant;

@Component
public class ApiRequest {

	@ServiceActivator(inputChannel = IntegrationConstant.HTTP_REQUEST_CHANNEL, outputChannel = IntegrationConstant.API_ROUTER)
	public Message<?> processRequest(Message<?> message) {
		System.out.println("Inside Http Request Process");
		return message;
	}

}
