package com.example.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.model.PersonData;
import com.example.addressbook.repository.IPersonRepository;

/**
 * PersonService : Business logic
 * 
 * @author praja
 *
 */
@Service
public class PersonService implements IPersonService {

	@Autowired
	private IPersonRepository presonRepository;

	/**
	 * Call Get method
	 * 
	 * @return : Contact details of the person
	 */
	@Override
	public List<PersonData> getPersonData() {
		return presonRepository.findAll();
	}

	/**
	 * Call Get method
	 * 
	 * @param id : contact Id
	 * @return : Contact details of the person
	 */
	@Override
	public PersonData getPersonDataById(int id) {
		return presonRepository.findById(id).get();
	}

	/**
	 * Call post method to add details
	 * 
	 * @param personDTO : details id, Firstname, Lastname, Address, City & phoneNum
	 * @return : details
	 */
	@Override
	public PersonData createPersonData(PersonDTO personDTO) {
		PersonData contactData = null;
		contactData = new PersonData(personDTO);
		return presonRepository.save(contactData);
	}

	/**
	 * Call put method to update details
	 * 
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
	 * 
	 * @param id : contact id
	 * @return : contact id which is deleted
	 */
	@Override
	public void deletePersonData(int id) {
		PersonData contactData = this.getPersonDataById(id);
		presonRepository.delete(contactData);
	}

}
