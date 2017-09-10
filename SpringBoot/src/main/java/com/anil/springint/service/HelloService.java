package com.anil.springint.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.anil.springint.constants.IntegrationConstant;

@Component
public class HelloService {

	@ServiceActivator(inputChannel = IntegrationConstant.HELLO_SERVICE_CAHNNEL, outputChannel = IntegrationConstant.HTTP_RESPONSE_CHANNEL)
	public Message testService(Message<?> message) {
		System.out.println("Inside test service");
		Message msg = MessageBuilder.fromMessage(message).withPayload("test service").build();
		return msg;
	}

}
