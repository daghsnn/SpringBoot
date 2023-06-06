package com.example.restfulapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan("com.example.restfulapp.io.repository")//hata geliyordu böyle compenenti scan edince duzeldi)
@SpringBootApplication
public class SbDemo01Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDemo01Application.class, args);
	}

}
