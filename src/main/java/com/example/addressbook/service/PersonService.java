package com.example.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.model.PersonData;
import com.example.addressbook.repository.IAddressBookRepository;
import com.example.addressbook.repository.IPersonRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class PersonService implements IPersonService {

	/**
	 * Introducing Dao layer to store the data in database
	 */
	@Autowired
	private IPersonRepository presonRepository;
	
	@Autowired
	private IAddressBookRepository addressBookRepo;

	/**
	 * Call Get method
	 * @return : Contact details of the person
	 */
	@Override
	public List<PersonData> getPersonData() {
		return presonRepository.findAll();
	}

	/**
	 * Call Get method
	 * @param id : contact Id
	 * @return : Contact details of the person
	 */
	@Override
	public PersonData getPersonDataById(int id) {
		return presonRepository.findById(id).get();
	}

	/**
	 * Call post method to add details
	 * @param personDTO : details id, Firstname, Lastname, Address, City & phoneNum
	 * @return : details
	 */
	@Override
	public PersonData createPersonData(int addressBookId, PersonDTO personDTO) {
		PersonData contactData = null;
		contactData = new PersonData(personDTO);
		Optional<AddressBookData> addressbook = addressBookRepo.findById(addressBookId);
		if(addressbook.isPresent())
		contactData.setAddressBook(addressbook.get());
		return presonRepository.save(contactData);
	}

	/**
	 * Call put method to update details
	 * @param personDTO : person details
	 * @return : details
	 */
	@Override
	public PersonData updatePersonData(int id, PersonDTO personDTO) {
		PersonData contactData = this.getPersonDataById(id);
		contactData.updatePersonData(personDTO);
		return presonRepository.save(contactData);
	}

	/**
	 * Call delete method to remove address book details
	 * @param id : contact id
	 * @return : contact id which is deleted
	 */
	@Override
	public void deletePersonData(int id) {
		PersonData contactData = this.getPersonDataById(id);
		presonRepository.delete(contactData);
	}

}
