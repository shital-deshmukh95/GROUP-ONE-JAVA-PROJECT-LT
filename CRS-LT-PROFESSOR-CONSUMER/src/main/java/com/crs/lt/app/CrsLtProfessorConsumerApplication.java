package com.crs.lt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@ComponentScan("com.crs.lt.*")
@EnableAutoConfiguration
@EnableWebMvc
@EnableEurekaClient
public class CrsLtProfessorConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtProfessorConsumerApplication.class, args);
	}

}
