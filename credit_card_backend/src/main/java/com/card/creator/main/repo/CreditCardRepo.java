/**
 * 
 */
package com.card.creator.main.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.card.creator.main.model.CreditCardDetails;

/**
 * @author Patrick-pc
 *
 */
@Repository
public interface CreditCardRepo extends JpaRepository<CreditCardDetails, Long> {

	Optional<CreditCardDetails> findByCardNumber(String cardNumber);

}
