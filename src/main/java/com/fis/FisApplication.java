package com.fis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FisApplication {

	static {
		System.setProperty("spring.config.location", "classpath:/application.yml");
	}

	public static void main(String[] args) {
		SpringApplication.run(FisApplication.class, args);
	}

}
