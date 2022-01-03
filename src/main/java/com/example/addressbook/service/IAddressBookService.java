package com.example.addressbook.service;

import java.util.List;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

public interface IAddressBookService {
	
	List<AddressBookData> getAddressBookData();

	AddressBookData createPersonData(AddressBookDTO addressDTO);

}
