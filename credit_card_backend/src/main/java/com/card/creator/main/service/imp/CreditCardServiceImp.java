/**
 * 
 */
package com.card.creator.main.service.imp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.card.creator.main.config.ApiError;
import com.card.creator.main.model.CreditCardDetails;
import com.card.creator.main.repo.CreditCardRepo;
import com.card.creator.main.service.CreditCardService;

/**
 * @author Patrick-pc
 *
 */
@Service
public class CreditCardServiceImp implements CreditCardService {

	@Autowired
	CreditCardRepo creditCardRepo;

	@Override
	public ResponseEntity<Object> saveCreditCardDetails(CreditCardDetails cardDetails) {
		if (!isValid(cardDetails.getCardNumber())) {
			return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "Card Number Is Not Valid"));
		}
		Optional<CreditCardDetails> optional = creditCardRepo.findByCardNumber(cardDetails.getCardNumber());
		if (optional.isPresent()) {
			return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "Card Number Already Exists"));
		}
		creditCardRepo.save(cardDetails);

		return buildResponseEntity(new ApiError(HttpStatus.OK, "New Card Added Successfully"));

	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

	@Override
	public List<CreditCardDetails> getAllCardsList() {
		return creditCardRepo.findAll();
	}

	private boolean isValid(String cardNum) {
		int[] cardIntArray = new int[cardNum.length()];
		for (int i = 0; i < cardNum.length(); i++) {
			char c = cardNum.charAt(i);
			cardIntArray[i] = Integer.parseInt("" + c);
		}
		for (int i = cardIntArray.length - 2; i >= 0; i = i - 2) {
			int num = cardIntArray[i];
			num = num * 2;
			if (num > 9) {
				num = num % 10 + num / 10;
			}
			cardIntArray[i] = num;
		}
		int sum = sumDigits(cardIntArray);
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	private static int sumDigits(int[] arr) {
		return Arrays.stream(arr).sum();
	}

}
