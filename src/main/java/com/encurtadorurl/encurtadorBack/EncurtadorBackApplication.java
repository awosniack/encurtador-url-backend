package com.encurtadorurl.encurtadorBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.encurtadorurl")
@SpringBootApplication
public class EncurtadorBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncurtadorBackApplication.class, args);
	}

}
