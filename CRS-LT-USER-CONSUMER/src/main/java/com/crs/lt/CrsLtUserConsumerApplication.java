package com.crs.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.crs.lt.*")
@EnableEurekaClient
@SpringBootApplication
public class CrsLtUserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtUserConsumerApplication.class, args);
	}

}
