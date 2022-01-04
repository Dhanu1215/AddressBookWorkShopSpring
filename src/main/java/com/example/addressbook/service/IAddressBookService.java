package com.example.addressbook.service;

import java.util.List;


import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

/**
 * Interface : Methods 
 * @author praja
 *
 */
public interface IAddressBookService {
	
	List<AddressBookData> getAddressBooks();

	AddressBookData createAddressBookData(AddressBookDTO addressDTO);

	AddressBookData getAddressBookById(int id);

	AddressBookData updateAddressBook(int id, AddressBookDTO addressDTO);

	void deleteAddressBook(int id);	
}
