package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.vaadin.flow.spring.annotation.EnableVaadin;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@EnableVaadin({"RouterAPItest","com.example.test","theming"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
