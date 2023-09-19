package com.vtxlab.demo.demohelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @Configuration
// @EnableAutoConfiguration
// @ComponentScan(Most important)

// ComponentScan is to scan @Controller, @Service, @Repository, @Configuration
// If yes, create an object of those classes
// and put that object into SpringContext
public class DemoHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoHelloworldApplication.class, args);
	}

}
