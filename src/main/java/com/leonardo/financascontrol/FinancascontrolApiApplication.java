package com.leonardo.financascontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FinancascontrolApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancascontrolApiApplication.class, args);
	}

}
