package com.kokai.shopping_list_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.kokai.entity")
@SpringBootApplication
@ComponentScan(basePackages = {"com.kokai.service", "com.kokai.controller"})
@EnableJpaRepositories(basePackages = "com.kokai.repository")
public class ShoppingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingListApplication.class, args);
        System.out.println("Code belongs to: @Kokai\nGitHub: https://github.com/K0kai\nShopping List API using Java Springboot\nVersion: 0.0.1");



    }

}
