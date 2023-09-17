package com.mc.House;


import com.mc.House.dao.ApartmentDAO;
import com.mc.House.dao.HouseMeetingDAO;
import com.mc.House.dao.UserDAO;
import com.mc.House.entity.Apartment;
import com.mc.House.entity.HouseMeeting;
import com.mc.House.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;


@SpringBootApplication
public class HouseDataApplication {

	// sqlite-jdbc, hibernate-community-dialects
	public static void main(String[] args) {
		SpringApplication.run(HouseDataApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO, ApartmentDAO apartmentDAO, HouseMeetingDAO houseMeetingDAO){
		return runner -> {
			System.out.println("App is running!");
		};
	}

}
