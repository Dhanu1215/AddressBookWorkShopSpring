package com.example.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponceDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.service.IAddressBookService;

/**
 * Rest Controller : AddressBookController
 * It handles Http request calls
 * @author praja
 */
@RestController
@RequestMapping("/addBook")
public class AddressBookController {


	/**
	 * @Autowired : Marks a constructor, field, setter method, or 
	 * configure method as to be autowired by Spring's dependency injection facilities.
	 */
	@Autowired
	private IAddressBookService addressBookService;
	
	/**
	 * Call get method 
	 * @return : Addressbook list
	 */
	@RequestMapping(value = { "/getBook" })
	public ResponseEntity<ResponceDTO> getAddressBooks() {
		List<AddressBookData> bookList = null;
		bookList = addressBookService.getAddressBooks();
		ResponceDTO respDTO = new ResponceDTO("Get Call Successful", bookList);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call get method to get addressbook by id
	 * @param id
	 * @return : Address book
	 */
	@GetMapping("/getBook/{id}")
	public ResponseEntity<ResponceDTO> getAddressBook(@PathVariable("id") int id) {
		AddressBookData book = null;
		book = addressBookService.getAddressBookById(id);
		ResponceDTO respDTO = new ResponceDTO("Get Call for Id Successful", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}

	/**
	 * Call post method to add data
	 * @param addressDTO
	 * @return : AddressBook data with book id
	 */
	@PostMapping("/createBook")
	public ResponseEntity<ResponceDTO> createAddressBookData(@Valid @RequestBody AddressBookDTO addressDTO) {
		AddressBookData book = null;
		book = addressBookService.createAddressBookData(addressDTO);
		ResponceDTO respDTO = new ResponceDTO("Created AddressBook Successfully", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call put method to update data of address book
	 * @param id
	 * @param addressDTO
	 * @return : Updated data of the address book
	 */
	@PutMapping("/updateBook/{id}")
	public ResponseEntity<ResponceDTO> updatePersonData(@PathVariable("id") int id,@Valid @RequestBody AddressBookDTO addressDTO) {
		AddressBookData book = null;
		book = addressBookService.updateAddressBook(id, addressDTO);
		ResponceDTO respDTO = new ResponceDTO("Updated AddressBook Successfully", book);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
	
	/**
	 * Call delete method to remove data of address book by id
	 * @param id
	 * @return : Delete status with id
	 */
	@DeleteMapping("/deleteBook/{id}")
	public ResponseEntity<ResponceDTO> deleteAddressBook(@Valid @PathVariable("id") int id) {
		addressBookService.deleteAddressBook(id);
		ResponceDTO respDTO = new ResponceDTO("Deleted AddressBook Successfully", "Deleted id : " + id);
		return new ResponseEntity<ResponceDTO>(respDTO, HttpStatus.OK);
	}
}
