package com.capg.fms.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FmsPassengerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsPassengerMsApplication.class, args);
	}

}
