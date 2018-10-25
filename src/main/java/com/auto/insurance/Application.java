package com.auto.insurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients(basePackageClasses = {CreditService.class})

public class Application {

	static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(Application.class, args);
	}

	public static ApplicationContext getApplicationContext(){
		return context;
	}
}
