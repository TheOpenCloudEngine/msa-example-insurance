package com.auto.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
@EnableEurekaClient
public class Application {

	static ConfigurableApplicationContext context;
	static UUID uuid = UUID.randomUUID();

	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}

	public static ApplicationContext getApplicationContext(){
		return context;
	}
}
