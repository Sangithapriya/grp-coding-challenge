package com.code.challenge.palindrome.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.code.challenge")
public class PalindromeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalindromeDemoApplication.class, args);
	}

}
