package com.kge.produce300;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Produce300Application {

	public static void main(String[] args) {
		SpringApplication.run(Produce300Application.class, args);
	}

}
