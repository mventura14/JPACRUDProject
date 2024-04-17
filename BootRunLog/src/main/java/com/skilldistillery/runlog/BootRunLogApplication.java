package com.skilldistillery.runlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.skilldistillery.runlog")
@EntityScan("com.skilldistillery.runlog")
public class BootRunLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootRunLogApplication.class, args);
	}

}
