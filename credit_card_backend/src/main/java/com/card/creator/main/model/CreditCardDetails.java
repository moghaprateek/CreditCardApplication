/**
 * 
 */
package com.card.creator.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Patrick-pc
 *
 */
@Entity(name = "credit_card_details")
public class CreditCardDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;

	@NotEmpty(message = "Please Enter The Card Number")
	@Size(max = 19, min = 13, message = "{Card Number Length Is Not Correct}")
	@Column(name = "card_number")
	private String cardNumber;

	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please Enter The Name")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Please Enter Valid Card Limit")
	@Column(name = "card_limit")
	private String cardLimit;

	/**
	 * 
	 */
	public CreditCardDetails() {
	}

	/**
	 * @param cardNumber
	 * @param name
	 * @param cardLimit
	 */
	public CreditCardDetails(
			@NotEmpty(message = "Please Enter The Card Number") @Size(max = 19, min = 13, message = "{Provide Valid Range Of Credit Card}") String cardNumber,
			@Size(max = 20, min = 3, message = "{user.name.invalid}") @NotEmpty(message = "Please Enter The Name") String name,
			@NotNull(message = "Please Enter Valid Card Limit") String cardLimit) {
		super();
		this.cardNumber = cardNumber;
		this.name = name;
		this.cardLimit = cardLimit;
	}

	/**
	 * @return the cardId
	 */
	public Long getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return the cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the cardLimit
	 */
	public String getCardLimit() {
		return cardLimit;
	}

	/**
	 * @param cardLimit the cardLimit to set
	 */
	public void setCardLimit(String cardLimit) {
		this.cardLimit = cardLimit;
	}

	@Override
	public String toString() {
		return "CreditCardDetails [cardId=" + cardId + ", cardNumber=" + cardNumber + ", name=" + name + ", cardLimit="
				+ cardLimit + "]";
	}

}
