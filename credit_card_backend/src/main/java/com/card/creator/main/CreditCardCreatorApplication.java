package com.card.creator.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.card.creator.main.model.CreditCardDetails;
import com.card.creator.main.service.CreditCardService;

@SpringBootApplication
public class CreditCardCreatorApplication {

	@Autowired
	CreditCardService service;

	public static void main(String[] args) {
		SpringApplication.run(CreditCardCreatorApplication.class, args);
	}

	@PostConstruct
	private void initDb() {
		service.saveCreditCardDetails(new CreditCardDetails("4473773446988190", "Raj Singh","10000"));
		service.saveCreditCardDetails(new CreditCardDetails("4473775055788894", "Vicky Kumar","43222"));
	}
}
