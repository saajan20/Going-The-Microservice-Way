package com.example.userbankaccount;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserBankAccountApplication {

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		
		System.out.println(String.valueOf(new Date()));
		SpringApplication.run(UserBankAccountApplication.class, args);
	}

}
