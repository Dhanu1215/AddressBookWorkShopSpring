package com.example.addressbook.dto;

import lombok.Data;
/**
 * Data transfer Object : AddressBookDTO
 * @author praja
 *
 */
public @Data class AddressBookDTO {

	@javax.validation.constraints.NotBlank(message = "Address book name can not be Empty")
	public String addressBookName;
	public int bookId;
}
