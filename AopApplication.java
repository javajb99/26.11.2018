package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@SpringBootApplication
public class AopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopApplication.class, args);
		
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
		
		Bank bank = ctx.getBean("bank", Bank.class);
		
		System.out.println( bank );
		
	}
}
