package com.mc.House;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HouseDataApplication {

	// sqlite-jdbc, hibernate-community-dialects for running from local DB
	public static void main(String[] args) {
		SpringApplication.run(HouseDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return runner -> {
			System.out.println("App is running!");
		};
	}

}
