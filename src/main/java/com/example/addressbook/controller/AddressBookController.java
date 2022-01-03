package com.example.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.addressbook.dto.ResponceDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.model.PersonData;
import com.example.addressbook.service.IAddressBookService;

public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@RequestMapping(value = { "/get" })
	public ResponseEntity<ResponceDTO> getPersonData() {
		List<AddressBookData> bookList = null;
		bookList = addressBookService.getAddressBookData();
		ResponceDTO respDTO = new ResponceDTO("Get Call Successful", bookList);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
//	
//	@GetMapping("/get/{id}")
//	public ResponseEntity<ResponceDTO> getPersonData(@PathVariable("id") int id) {
//		PersonData personData = null;
//		personData = addressBookService.getAddressBookDataById(id);
//		ResponceDTO respDTO = new ResponceDTO("Get Call for Id Successful", personData);
//		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
//	}
}
