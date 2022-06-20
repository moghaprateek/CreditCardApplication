/**
 * 
 */
package com.card.creator.main.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.card.creator.main.model.CreditCardDetails;
import com.card.creator.main.service.CreditCardService;

/**
 * @author Patrick-pc
 *
 */
@CrossOrigin
@RestController("/")
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@GetMapping
	public ResponseEntity<List<CreditCardDetails>> getAllUsers() {
		List<CreditCardDetails> creditCardDetails = creditCardService.getAllCardsList();
		return ResponseEntity.ok().body(creditCardDetails);
	}

	@PostMapping("/add")
	public ResponseEntity<Object> saveCreditCardDetails(@Valid @RequestBody CreditCardDetails cardDetails) {

		return creditCardService.saveCreditCardDetails(cardDetails);

	}

}
