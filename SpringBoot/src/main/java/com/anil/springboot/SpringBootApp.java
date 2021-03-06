package com.anil.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
public class SpringBootApp {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootApp.class);
		application.run(args);
	}

}
