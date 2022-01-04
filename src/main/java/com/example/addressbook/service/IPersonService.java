package com.example.addressbook.service;

import java.util.List;

import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.model.PersonData;

/**
 * Interface : Methods 
 * @author praja
 *
 */
public interface IPersonService {
	
	List<PersonData> getPersonData();
	PersonData getPersonDataById(int id);
	void deletePersonData(int id);
	PersonData createPersonData(int addressBookId, PersonDTO personDTO);
	PersonData updatePersonData(int id, PersonDTO personDTO);
}
