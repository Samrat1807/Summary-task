package com.samrat.summarytask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SummaryTaskApplication {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		SpringApplication.run(SummaryTaskApplication.class, args);
		long endTime= System.currentTimeMillis();
		System.out.println("Time elapsed:" +(endTime-startTime));
	}

}
