package com.example.addressbook.model;

import lombok.Data;

/**
 * Persons details 
 * @author praja
 *
 */
public @Data class PersonData {
	
	private int personId;
	private String firstName;
	private String lastName;
	private String gender;
	private long phoneNum;
	private String email;
	private String city;
	private String state;
	private String country;
	private String address;
	private String profilePic;
	
	
	public PersonData() {
		
	}
	public PersonData(int personId, String firstName, String lastName, String gender, long phoneNum, String email,
			String city, String state, String country, String address, String profilePic) {
		super();
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNum = phoneNum;
		this.email = email;
		this.city = city;
		this.state = state;
		this.country = country;
		this.address = address;
		this.profilePic = profilePic;
	}
	
}
