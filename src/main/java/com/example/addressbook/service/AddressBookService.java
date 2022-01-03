package com.example.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.repository.IAddressBookRepository;

public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepository addressBookRepositoty;
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepositoty.findAll();
	}

}
