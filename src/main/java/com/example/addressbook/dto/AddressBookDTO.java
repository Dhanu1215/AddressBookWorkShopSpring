package com.example.addressbook.dto;

import java.util.List;

import lombok.Data;

public @Data class AddressBookDTO {

	public int id;
	public String addressBookName;
	public List personList;
	
	public AddressBookDTO(int id, String addressBookName, List personList) {
		super();
		this.id = id;
		this.addressBookName = addressBookName;
		this.personList = personList;
	}
	
}
