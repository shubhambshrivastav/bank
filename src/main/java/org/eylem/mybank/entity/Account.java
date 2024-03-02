package org.eylem.mybank.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eylem.mybank.dto.AccountDto;
import org.eylem.mybank.enums.AccountType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue
    private UUID id;
    private String accountNumber;
    private int balance;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate modifiedDate;
    private String iban;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "account",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Card> cards;

    
    
    public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public LocalDate getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public LocalDate getModifiedDate() {
		return modifiedDate;
	}



	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}



	public String getIban() {
		return iban;
	}



	public void setIban(String iban) {
		this.iban = iban;
	}



	public String getCurrency() {
		return currency;
	}



	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public AccountType getAccountType() {
		return accountType;
	}



	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Set<Card> getCards() {
		return cards;
	}



	public void setCards(Set<Card> cards) {
		this.cards = cards;
	}


	public AccountDto accountDto() {
	    AccountDto accountDto = new AccountDto();
	    accountDto.setId(this.id);
	    accountDto.setAccountNumber(this.accountNumber);
	    accountDto.setBalance(this.balance);
	    accountDto.setCreatedDate(this.createdDate);
	    accountDto.setModifiedDate(this.modifiedDate);
	    accountDto.setIban(this.iban);
	    accountDto.setCurrency(this.currency);
	    accountDto.setAccountType(this.accountType);
	    return accountDto;
	}
}
