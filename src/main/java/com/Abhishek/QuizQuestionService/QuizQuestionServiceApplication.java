package com.Abhishek.QuizQuestionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class QuizQuestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizQuestionServiceApplication.class, args);
	}

}
