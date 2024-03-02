package org.eylem.mybank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eylem.mybank.dto.CardDto;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue
    private UUID id;
    private String cardNumber;
    private int boundary=2000;
    private int debt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    private Account account;

    
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


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	public CardDto cardDto() {
	    CardDto cardDto = new CardDto();
	    cardDto.setId(this.id);
	    cardDto.setCardNumber(this.cardNumber);
	    cardDto.setBoundary(this.boundary);
	    cardDto.setDebt(this.debt);
	    return cardDto;
	}
}
