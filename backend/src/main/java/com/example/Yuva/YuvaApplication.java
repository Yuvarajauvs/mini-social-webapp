package com.example.Yuva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EnableCaching
public class YuvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(YuvaApplication.class, args);


		System.out.println("Hello successfully");
	}
}
