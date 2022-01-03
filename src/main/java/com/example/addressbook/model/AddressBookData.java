package com.example.addressbook.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.example.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Entity
public @Data class AddressBookData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookId;
	private String addressBookName;
	
	
	public AddressBookData(int bookId, String addressBookName) {
		super();
		this.bookId = bookId;
		this.addressBookName = addressBookName;
	}

	public AddressBookData(AddressBookDTO addressDTO) {
	}

	@OneToMany(targetEntity = PersonData.class,cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id",referencedColumnName = "bookId")
	private List<PersonData>personList;
	
}
