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
	private IAddressBookRepository addressBookRepository;
	
	@Override
	public List<AddressBookData> getAddressBooks() {
		return addressBookRepository.findAll();
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressDTO);
		return addressBookRepository.save(contactData);
	}

	@Override
	public AddressBookData getAddressBookById(int id) {
		return addressBookRepository.findById(id).get();
	}

	@Override
	public AddressBookData updateAddressBook(int id, AddressBookDTO addressDTO) {
		AddressBookData book = this.getAddressBookById(id);
		book.updateAddressBook(addressDTO);
		return addressBookRepository.save(book);
	}

	@Override
	public void deleteAddressBook(int id) {
		AddressBookData book = this.getAddressBookById(id);
		addressBookRepository.delete(book);
	}

}
