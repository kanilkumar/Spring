package com.anil.springint.router;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import com.anil.springint.constants.IntegrationConstant;

@Component
public class ApiRouter {

	@Router(inputChannel = IntegrationConstant.API_ROUTER)
	public String route(Message<?> message) {
		System.out.println("Inside Api Router");
		return IntegrationConstant.HELLO_SERVICE_CAHNNEL;
	}

}
