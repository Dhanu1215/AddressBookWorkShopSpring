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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.PersonDTO;
import com.example.addressbook.dto.ResponceDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.model.PersonData;
import com.example.addressbook.service.IAddressBookService;

@RestController
@RequestMapping("/addBook")
public class AddressBookController {

	@Autowired
	private IAddressBookService addressBookService;
	
	@RequestMapping(value = { "/getBook" })
	public ResponseEntity<ResponceDTO> getAddressBooks() {
		List<AddressBookData> bookList = null;
		bookList = addressBookService.getAddressBooks();
		ResponceDTO respDTO = new ResponceDTO("Get Call Successful", bookList);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getBook/{id}")
	public ResponseEntity<ResponceDTO> getAddressBook(@PathVariable("id") int id) {
		AddressBookData book = null;
		book = addressBookService.getAddressBookById(id);
		ResponceDTO respDTO = new ResponceDTO("Get Call for Id Successful", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	@PostMapping("/createBook")
	public ResponseEntity<ResponceDTO> createAddressBookData(@RequestBody AddressBookDTO addressDTO) {
		AddressBookData book = null;
		book = addressBookService.createAddressBookData(addressDTO);
		ResponceDTO respDTO = new ResponceDTO("Created AddressBook Successfully", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<ResponceDTO> updatePersonData(@PathVariable("id") int id, @RequestBody AddressBookDTO addressDTO) {
		AddressBookData book = null;
		book = addressBookService.updateAddressBook(id, addressDTO);
		ResponceDTO respDTO = new ResponceDTO("Updated AddressBook Successfully", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<ResponceDTO> deleteAddressBook(@PathVariable("id") int id) {
		addressBookService.deleteAddressBook(id);
		ResponceDTO respDTO = new ResponceDTO("Deleted AddressBook Successfully", "Deleted id : " + id);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
}
