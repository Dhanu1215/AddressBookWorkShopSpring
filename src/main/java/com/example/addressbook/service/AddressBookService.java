package com.example.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepository addressBookRepositoty;
	
	@Override
	public List<AddressBookData> getAddressBookData() {
		return addressBookRepositoty.findAll();
	}

	@Override
	public AddressBookData createPersonData(AddressBookDTO addressDTO) {
		AddressBookData addressData = null;
		addressData  = new AddressBookData(addressDTO);
		return addressBookRepositoty.save(addressData );
	}

}
