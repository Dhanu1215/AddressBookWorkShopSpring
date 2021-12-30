package com.example.addressbook.dto;
import lombok.Data;
/**
 * Person data transfer object
 * @author praja
 *
 */
public @Data class PersonDTO {
	public String firstName;
	public String lastName;
	public String gender;
	public long phoneNum;
	public String email;
	public String city;
	public String state;
	public String country;
	public String address;
	public String profilePic;
	
	public PersonDTO( String firstName, String lastName, String gender, long phoneNum, String email,
			String city, String state, String country, String address, String profilePic) {
		super();
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
