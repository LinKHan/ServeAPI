package com.ak.restAPIBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RestApiBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiBootApplication.class, args);
	}

}
