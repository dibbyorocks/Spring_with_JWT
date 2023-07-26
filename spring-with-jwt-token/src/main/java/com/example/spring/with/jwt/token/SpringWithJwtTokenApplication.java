package com.example.spring.with.jwt.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringWithJwtTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWithJwtTokenApplication.class, args);
	}

}
