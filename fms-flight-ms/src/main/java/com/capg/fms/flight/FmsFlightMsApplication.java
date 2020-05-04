package com.capg.fms.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 
public class FmsFlightMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsFlightMsApplication.class, args);
	}

}
