package com.example.monnifyintegration;

import com.example.monnifyintegration.DTOs.Configs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonnifyIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonnifyIntegrationApplication.class, args);
	}

	@Bean
	public Configs getConfig(){
		Configs dto = new Configs();
		dto.setApiKey(System.getenv("MONNIFY_API_KEY"));
		dto.setApiSecret(System.getenv("MONNIFY_SECRET_KEY"));
		dto.setBaseUrl(System.getenv("MONNIFY_BASE_URL"));
		dto.setContractCode(System.getenv("MONNIFY_CONTRACT_CODE"));
		dto.setEmail("");
		dto.setPass("");
		return dto;
	}
}
