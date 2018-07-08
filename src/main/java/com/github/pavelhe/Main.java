package com.github.pavelhe;

import com.github.pavelhe.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		runQuestionApp();
	}

	private static void runQuestionApp() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
		StudentController controller = context.getBean(StudentController.class);
		controller.startAnswers();
	}
}
