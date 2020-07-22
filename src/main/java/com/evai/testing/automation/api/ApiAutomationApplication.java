package com.evai.testing.automation.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.evai")
@SpringBootApplication
public class ApiAutomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAutomationApplication.class, args);
	}

}
