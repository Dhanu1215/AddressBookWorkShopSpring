package com.example.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.addressbook.dto.PersonDTO;

import lombok.Data;

/**
 * Persons details
 * 
 * @author praja
 *
 */
@Entity
@Table(name = "person_data")
public @Data class PersonData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
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

	public PersonData(PersonDTO personDTO) {
		this.updatePersonData(personDTO);
	}

	public void updatePersonData(PersonDTO personDTO) {
		this.firstName = personDTO.firstName;
		this.lastName = personDTO.lastName;
		this.gender = personDTO.gender;
		this.phoneNum = personDTO.phoneNum;
		this.email = personDTO.email;
		this.city = personDTO.city;
		this.state = personDTO.state;
		this.country = personDTO.country;
		this.address = personDTO.address;
		this.profilePic = personDTO.profilePic;

	}

}
