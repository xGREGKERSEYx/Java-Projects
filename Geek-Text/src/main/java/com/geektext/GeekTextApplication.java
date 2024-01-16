package com.geektext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// This annotation indicates that this class is the main entry point for the Spring Boot application
@SpringBootApplication
public class GeekTextApplication {
        
	public static void main(String[] args) {
		SpringApplication.run(GeekTextApplication.class, args);
                // This method runs the Spring Boot application and starts the embedded Tomcat server
        
	}// The starting point of the application

}
