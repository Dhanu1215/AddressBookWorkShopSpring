package com.example.addressbook.service;

import java.util.List;

import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.model.PersonData;

public interface IAddressBookService {
	
	List<AddressBookData> getAddressBookData();

}
