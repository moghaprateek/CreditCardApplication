/**
 * 
 */
package com.card.creator.main.model;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Patrick-pc
 *
 */
public class CardNumberValidator implements ConstraintValidator<CardNumberConstraints, String> {

	@Override
	public void initialize(CardNumberConstraints contactNumber) {
	}

	@Override
	public boolean isValid(String cardNumber, ConstraintValidatorContext context) {
		// int array for processing the cardNumber
		System.out.println("Card Number >>>" + cardNumber);
		int[] cardIntArray = new int[cardNumber.length()];
		for (int i = 0; i < cardNumber.length(); i++) {
			char c = cardNumber.charAt(i);
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
		System.out.println(sum);
		if (sum % 10 == 0) {
			return true;
		}
		return false;
	}

	public static int sumDigits(int[] arr) {
		return Arrays.stream(arr).sum();
	}

}
