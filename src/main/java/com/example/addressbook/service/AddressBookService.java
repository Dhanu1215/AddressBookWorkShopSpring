package com.example.addressbook.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.repository.IAddressBookRepository;

/**
 * Service layer :Business logic
 * @author praja
 */
@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepository addressBookRepository;
	

	/**
	 * Call get method 
	 * @return : Addressbook list
	 */
	@Override
	public List<AddressBookData> getAddressBooks() {
		return addressBookRepository.findAll();
	}


	/**
	 * Call post method to add data
	 * @param addressDTO
	 * @return : AddressBook data with book id
	 */
	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressDTO) {
		AddressBookData contactData = null;
		contactData = new AddressBookData(addressDTO);
		return addressBookRepository.save(contactData);
	}

	/**
	 * Call get method to get addressbook by id
	 * @param id
	 * @return : Address book
	 */
	@Override
	public AddressBookData getAddressBookById(int id) {
		return addressBookRepository.findById(id).get();
	}
	
	/**
	 * Call put method to update data of address book
	 * @param id
	 * @param addressDTO
	 * @return : Updated data of the address book
	 */
	@Override
	public AddressBookData updateAddressBook(int id, AddressBookDTO addressDTO) {
		AddressBookData book = this.getAddressBookById(id);
		book.updateAddressBook(addressDTO);
		return addressBookRepository.save(book);
	}

	/**
	 * Call delete method to remove data of address book by id
	 * @param id
	 * @return : Delete status with id
	 */
	@Override
	public void deleteAddressBook(int id) {
		AddressBookData book = this.getAddressBookById(id);
		addressBookRepository.delete(book);
	}

}
