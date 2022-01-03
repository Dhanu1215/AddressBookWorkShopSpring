package com.example.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.dto.ResponceDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.service.IAddressBookService;

@RestController
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@RequestMapping(value = { "/getBook" })
	public ResponseEntity<ResponceDTO> getPersonData() {
		List<AddressBookData> bookList = null;
		bookList = addressBookService.getAddressBookData();
		ResponceDTO respDTO = new ResponceDTO("Get Call Successful", bookList);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/createBook")
	public ResponseEntity<ResponceDTO> createPersonData(@RequestBody AddressBookDTO addressDTO) {
		AddressBookData addressData = null;
		addressData = addressBookService.createPersonData(addressDTO);
		ResponceDTO respDTO = new ResponceDTO("Created AddressBook Successfully", addressData);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
}
