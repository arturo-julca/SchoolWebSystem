package com.komodo.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.komodo.school.controller.HomeController;

@SpringBootApplication
//@ComponentScan(basePackageClasses = HomeController.class)

public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
