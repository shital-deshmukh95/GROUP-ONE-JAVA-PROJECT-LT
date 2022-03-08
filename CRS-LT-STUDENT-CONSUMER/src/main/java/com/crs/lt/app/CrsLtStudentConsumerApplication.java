package com.crs.lt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableEurekaClient
@ComponentScan("com.crs.lt*")
@EnableAutoConfiguration
@EnableWebMvc
@SpringBootApplication
public class CrsLtStudentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtStudentConsumerApplication.class, args);
	}

}
