package com.example.bankservice.business_object;

import java.math.BigDecimal;

public class Account {
     private Long id;
     private Client client;
     private AccountType accountType;
     //private String email;
     private BigDecimal balance;
     private BigDecimal minBalance;
     
	public Account(Long id, Client client, AccountType accountType,  BigDecimal balance,
			BigDecimal minBalance) {
		super();
		this.id = id;
		this.client = client;
		this.accountType = accountType;
		//this.email = email;
		this.balance = balance;
		this.minBalance = minBalance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(BigDecimal minBalance) {
		this.minBalance = minBalance;
	}
	
	@Override
	public String toString() {
		return "id=" + id + ", client=" + client + ", accountType=" + accountType 
				+ ", balance=" + balance + ", minBalance=" + minBalance + "\n";
	}
     
     
}
