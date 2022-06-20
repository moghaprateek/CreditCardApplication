/**
 * 
 */
package com.card.creator.main.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.card.creator.main.model.CreditCardDetails;

/**
 * @author Patrick-pc
 *
 */
public interface CreditCardService {

	ResponseEntity<Object> saveCreditCardDetails(CreditCardDetails cardDetails);

	List<CreditCardDetails> getAllCardsList();

}
