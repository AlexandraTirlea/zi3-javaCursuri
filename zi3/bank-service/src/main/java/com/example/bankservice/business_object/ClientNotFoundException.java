package com.example.bankservice.business_object;

public class ClientNotFoundException extends RuntimeException{
	
	public ClientNotFoundException(Long id) {
		super("Client "+id+" was not found!");
	}

}
