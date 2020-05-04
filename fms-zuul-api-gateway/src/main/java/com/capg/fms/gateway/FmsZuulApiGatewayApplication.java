package com.capg.fms.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class FmsZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmsZuulApiGatewayApplication.class, args);
	}

}
