package com.ars;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AppRegistrationServiceApplication {
	
	@Value("${ssn-web.base-url}")
	private String base_url;

	public static void main(String[] args) {
		SpringApplication.run(AppRegistrationServiceApplication.class, args);
	}
	
	@Bean
	public WebClient getClient()
	{
		return WebClient.create(base_url);
	}

}
