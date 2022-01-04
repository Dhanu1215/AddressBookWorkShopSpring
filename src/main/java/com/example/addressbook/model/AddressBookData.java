package com.example.addressbook.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.addressbook.dto.AddressBookDTO;

import lombok.Data;
@Entity
public @Data class AddressBookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name=" book_id")
	private int bookId;
	private String addressBookName;
	
	public AddressBookData() {
		super();
	}

	public AddressBookData(AddressBookDTO bookDTO) {
		super();
		this.updateAddressBook(bookDTO);
	}

	public void updateAddressBook(AddressBookDTO bookDTO) {
		this.addressBookName = bookDTO.addressBookName;
	}
	
}
