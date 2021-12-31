package com.example.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.dto.ResponceDTO;
import com.example.addressbook.model.PersonData;
import com.example.addressbook.service.IPersonService;

/**
 * Rest Controller to handle the all rest calls
 * 
 * @author praja
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private IPersonService personService;

	/**
	 * Call Get method to handle get call
	 * It returns contact details of person
	 * @return : Http Status & Contact details of the person
	 */
	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponceDTO> getPersonData() {
		List<PersonData> personList = null;
		personList = personService.getPersonData();
		ResponceDTO respDTO = new ResponceDTO("Get Call Successful", personList);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call Get method 
	 * It returns contact details of the person by contact Id
	 * @param id : contact Id
	 * @return : Contact details of the person
	 */
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponceDTO> getPersonData(@PathVariable("id") int id) {
		PersonData personData = null;
		personData = personService.getPersonDataById(id);
		ResponceDTO respDTO = new ResponceDTO("Get Call for Id Successful", personData);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add details
	 * It creates the contact details of person
	 * @param personDTO : details id, Firstname, Lastname, Address, City & phoneNum etc.
	 * @return : details
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponceDTO> createPersonData(@RequestBody PersonDTO presonDTO) {
		PersonData contactData = null;
		contactData = personService.createPersonData(presonDTO);
		ResponceDTO respDTO = new ResponceDTO("Created AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call put method to update details
	 * It update the contact details of person by id.
	 * @param personDTO : details id, Firstname, Lastname, Address, City & phoneNum
	 * @return : details
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponceDTO> updatePersonData(@PathVariable("id") int id, @RequestBody PersonDTO personDTO) {
		PersonData contactData = null;
		contactData = personService.updatePersonData(id, personDTO);
		ResponceDTO respDTO = new ResponceDTO("Updated AddressBook data Successfully", contactData);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call delete method to remove address book details
	 * It delete the contact details of the person by id
	 * @param id : Address book id
	 * @return : contact id which is deleted
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponceDTO> deletePersonData(@PathVariable("id") int id) {
		personService.deletePersonData(id);
		ResponceDTO respDTO = new ResponceDTO("Deleted AddressBook data Successfully", "Deleted id : " + id);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
}
