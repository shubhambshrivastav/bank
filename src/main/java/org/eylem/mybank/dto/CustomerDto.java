package org.eylem.mybank.dto;

import lombok.*;
import org.eylem.mybank.dto.AccountDto;
import org.eylem.mybank.dto.CardDto;
import org.eylem.mybank.entity.Customer;

import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class CustomerDto {
    private UUID id;
    @NotBlank(message = "Name is necessary")
    private String name;
    @NotBlank(message = "Surname is necessary")
    private String surname;
    private Set<AccountDto> accounts;
    private Set<CardDto> cards;
    
    

    public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public Set<AccountDto> getAccounts() {
		return accounts;
	}



	public void setAccounts(Set<AccountDto> accounts) {
		this.accounts = accounts;
	}



	public Set<CardDto> getCards() {
		return cards;
	}



	public void setCards(Set<CardDto> cards) {
		this.cards = cards;
	}


	public Customer toCustomer() {
	    Customer customer = new Customer();
	    customer.setId(this.id);
	    customer.setName(this.name);
	    customer.setSurname(this.surname);
	    
	    // Uncomment the following lines if you want to map accounts and cards
	    /*
	    Set<Account> accountSet = new HashSet<>();
	    if (this.accounts != null) {
	        for (AccountDto accountDto : this.accounts) {
	            accountSet.add(accountDto.toAccount());
	        }
	    }
	    customer.setAccounts(accountSet);

	    Set<Card> cardSet = new HashSet<>();
	    if (this.cards != null) {
	        for (CardDto cardDto : this.cards) {
	            cardSet.add(cardDto.toCard());
	        }
	    }
	    customer.setCards(cardSet);
	    */
	    
	    return customer;
	}
}