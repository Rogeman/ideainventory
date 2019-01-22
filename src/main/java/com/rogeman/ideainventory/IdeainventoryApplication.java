package com.rogeman.ideainventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IdeainventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeainventoryApplication.class, args);
	}
	
	

}

