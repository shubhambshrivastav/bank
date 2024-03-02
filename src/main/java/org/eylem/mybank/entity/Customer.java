package org.eylem.mybank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.eylem.mybank.dto.AccountDto;
import org.eylem.mybank.dto.CardDto;
import org.eylem.mybank.dto.CustomerDto;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "customer")
    private Set<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private Set<Card> cards;

    
    
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



	public Set<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}



	public Set<Card> getCards() {
		return cards;
	}



	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}


	public CustomerDto customerDto() {
	    CustomerDto customerDto = new CustomerDto();
	    customerDto.setId(this.id);
	    customerDto.setName(this.name);
	    customerDto.setSurname(this.surname);

	    // Assuming you have a no-args constructor for AccountDto and CardDto
	    Set<AccountDto> accountDtos = new HashSet<>();
	    if (this.accounts != null) {
	        for (Account account : this.accounts) {
	            accountDtos.add(account.accountDto());
	        }
	    }
	    customerDto.setAccounts(accountDtos);

	    Set<CardDto> cardDtos = new HashSet<>();
	    if (this.cards != null) {
	        for (Card card : this.cards) {
	            cardDtos.add(card.cardDto());
	        }
	    }
	    customerDto.setCards(cardDtos);

	    return customerDto;
	}
}
