package com.microservices.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);

//		SpringApplication app = new SpringApplication(ApiGatewayApplication.class);
//		app.setWebApplicationType(WebApplicationType.REACTIVE);
//		SpringApplication.run(ApiGatewayApplication.class,args);
	}
}
