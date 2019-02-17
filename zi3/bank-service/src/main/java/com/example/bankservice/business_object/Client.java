package com.example.bankservice.business_object;

import java.time.LocalDate;

public class Client {
   private Long id;
   private String name;
   private String email;
   private String phoneNumber;
   private LocalDate dateOfBirth;
   private Boolean active;
   
public Client() {}
public Client(Long id, String name, String email, String phoneNumber, LocalDate dateOfBirth, Boolean active) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.dateOfBirth = dateOfBirth;
	this.active = active;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public LocalDate getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public Boolean getActive() {
	return active;
}
public void setActive(Boolean active) {
	this.active = active;
}

@Override
public String toString() {
	return "id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", dateOfBirth=" + dateOfBirth
			+ ", Active=" + active + "\n";
}
   
   
}
