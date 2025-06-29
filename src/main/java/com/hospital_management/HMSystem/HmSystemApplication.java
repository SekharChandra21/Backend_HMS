package com.hospital_management.HMSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class HmSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HmSystemApplication.class, args);
	}

	@GetMapping
	public String home() {
		return "Welcome to the Hospital Management System!";
	}

}
