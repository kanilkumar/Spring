package com.anil.springint.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.Router;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.http.inbound.HttpRequestHandlingMessagingGateway;
import org.springframework.integration.http.inbound.RequestMapping;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.anil.springint.constants.IntegrationConstant;


@Configuration
@ComponentScan(basePackages = "com.anil")
@PropertySource(value = { "application.properties" })
public class IntegrationConfiguration {

	@Bean
	public HttpRequestHandlingMessagingGateway httpMessageHandlingGateway() {
		HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway();
		gateway.setRequestChannel(httpRequestChannel());
		gateway.setReplyChannel(httpResponseChannel());
		gateway.setErrorChannel(httpErrorChannel());
		RequestMapping requestMapping = new RequestMapping();
		requestMapping.setMethods(HttpMethod.GET, HttpMethod.POST);
		requestMapping.setPathPatterns("/testService");
		gateway.setRequestMapping(requestMapping);
		return gateway;
	}

	@Bean
	public MessageChannel httpRequestChannel() {
		DirectChannel channel = new DirectChannel();
		return channel;
	}

	@Bean
	public MessageChannel httpResponseChannel() {
		DirectChannel channel = new DirectChannel();
		return channel;
	}

	@Bean
	public MessageChannel httpErrorChannel() {
		DirectChannel channel = new DirectChannel();
		return channel;
	}
	
	/*@Bean
	@Router(inputChannel = IntegrationConstant.API_ROUTER)
	public String route(Message<?> message) {
		System.out.println("Inside Api Router");
		return IntegrationConstant.HELLO_SERVICE_CAHNNEL;
	}*/
	
}
