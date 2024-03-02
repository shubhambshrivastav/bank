package org.eylem.mybank.dto;
import org.eylem.mybank.enums.AccountType;

import lombok.Builder;
import lombok.Data;

import org.eylem.mybank.entity.Account;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class AccountDto {
    private UUID id;
    private String accountNumber;
    private int balance;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String iban;
    private String currency;
    private AccountType accountType;

    
    
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

	public AccountDto() {

    }

    public AccountDto(UUID id, String accountNumber, int balance, LocalDate createdDate, LocalDate modifiedDate, String iban, String currency, AccountType accountType) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.iban = iban;
        this.currency = currency;
        this.accountType = accountType;
    }

    public Account toAccount() {
        Account account = new Account();
        account.setId(this.id);
        account.setAccountNumber(this.accountNumber);
        account.setBalance(this.balance);
        account.setCreatedDate(this.createdDate);
        account.setModifiedDate(this.modifiedDate);
        account.setIban(this.iban);
        account.setCurrency(this.currency);
        account.setAccountType(this.accountType);
        return account;
    }
}
