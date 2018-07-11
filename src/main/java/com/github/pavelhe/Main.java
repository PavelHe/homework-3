package com.github.pavelhe;

import com.github.pavelhe.controller.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private StudentController controller;

    @Override
    public void run(String... strings) throws Exception {
        controller.startAnswers();
    }
}
