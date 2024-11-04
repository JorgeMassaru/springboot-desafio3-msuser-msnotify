package com.jorgeMassaru.desafio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableFeignClients(basePackages = "com.jorgeMassaru.desafio3")
public class Desafio3Application {
	public static void main(String[] args) {
		SpringApplication.run(Desafio3Application.class, args);
	}
}
