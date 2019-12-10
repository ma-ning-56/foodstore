package com.maning.foodstoreweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.maning.foodstoreweb.dto.auto")
public class FoodstoreWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodstoreWebApplication.class, args);
	}

}
