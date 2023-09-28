package com.project.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.project.application.entities")
public class YourApplication {
	 public static void main(String[] args) {
	        SpringApplication.run(YourApplication.class, args);
	    }
}
