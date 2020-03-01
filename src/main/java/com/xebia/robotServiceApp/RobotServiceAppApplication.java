package com.xebia.robotServiceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RobotServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotServiceAppApplication.class, args);
	}

}
