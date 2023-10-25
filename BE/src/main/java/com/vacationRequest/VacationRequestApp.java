package com.vacationRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class VacationRequestApp {

	public static void main(String[] args) {
		SpringApplication.run(VacationRequestApp.class, args);
	}
}
