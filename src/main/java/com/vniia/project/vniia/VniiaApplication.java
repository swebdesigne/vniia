package com.vniia.project.vniia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.vniia.project.vniia.repository")
public class VniiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VniiaApplication.class, args);
	}

}
