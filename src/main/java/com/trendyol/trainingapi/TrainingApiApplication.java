package com.trendyol.trainingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class TrainingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingApiApplication.class, args);
	}

}
