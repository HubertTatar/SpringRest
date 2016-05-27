package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example")
public class SpringDateApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDateApplication.class, args);
	}
}
