package com.example.restfulapp;

import com.example.restfulapp.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@ComponentScan("com.example.restfulapp.io.repository")//hata geliyordu böyle compenenti scan edince duzeldi)
//@ComponentScan("com.example.restfulapp.repository")
//@ComponentScan(basePackageClasses = UserController.class)
//@SpringBootApplication(scanBasePackages={
//		"com.example.restfulapp"})

@SpringBootApplication
public class SbDemo01Application {

	public static void main(String[] args) {
		SpringApplication.run(SbDemo01Application.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
