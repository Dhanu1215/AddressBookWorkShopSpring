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
	
	PersonData createPersonData(PersonDTO personDTO);
	
	PersonData updatePersonData( int id,PersonDTO personDTO);
	
	void deletePersonData(int id);
}
