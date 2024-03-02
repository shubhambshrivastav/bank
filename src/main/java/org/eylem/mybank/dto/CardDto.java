package org.eylem.mybank.dto;

import lombok.*;
import org.eylem.mybank.entity.Card;

import java.util.UUID;

@Data
@Builder
public class CardDto {
    private UUID id;
    private String cardNumber;
    private int boundary;
    private int debt;
    
    

    public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	public int getBoundary() {
		return boundary;
	}



	public void setBoundary(int boundary) {
		this.boundary = boundary;
	}



	public int getDebt() {
		return debt;
	}



	public void setDebt(int debt) {
		this.debt = debt;
	}


	public Card toCard() {
	    Card card = new Card();
	    card.setId(this.id);
	    card.setCardNumber(this.cardNumber);
	    card.setBoundary(this.boundary);
	    card.setDebt(this.debt);
	    return card;
	}
}
