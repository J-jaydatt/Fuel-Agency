package com.faos.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.faos.repo")
@EntityScan("com.faos.model")
@ComponentScan(basePackages = {"com.faos.controller","com.faos.service"})
public class FuelAgencyOperationsSuiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuelAgencyOperationsSuiteApplication.class, args);
	}

}

