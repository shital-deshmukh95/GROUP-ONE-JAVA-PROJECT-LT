package com.crs.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class CrsLtAdminConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtAdminConsumerApplication.class, args);
	}

}
