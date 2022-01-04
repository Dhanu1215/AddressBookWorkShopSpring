package com.example.addressbook.dto;

import javax.validation.constraints.Pattern;
import lombok.ToString;

/**
 * Person data transfer object
 * @author praja
 *
 */

public @ToString class PersonDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "firstname is Invalid")
	public String firstName;
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "lastname is Invalid")
	public String lastName;
	
	@Pattern(regexp = "male|female",message = "Gender should be male or female")
	public String gender;
	
	//@Pattern(regexp ="^[91]{2} [0-9]{10}$",message = "Phone number is Invalid")
	public long phoneNum;

	@Pattern(regexp = "(([a-z A-Z]{3,})([-$&+,:;=?#|'<>.^*()%!]?[0-9 a-z A-Z]{3,})?+@([0-9 a-z]{1,})([.])([a-z]{2,})([.])?([a-z]{2,})?)",message = "Email is Invalid")
	public String email;
	
	@javax.validation.constraints.NotBlank(message = "city can not be Empty")
	public String city;
	
	@javax.validation.constraints.NotBlank(message = "state can not be Empty")
	public String state;
	
	@javax.validation.constraints.NotBlank(message = "country can not be Empty")
	public String country;
	
	@javax.validation.constraints.NotBlank(message = "Address can not be Empty")
	public String address;
	
	@javax.validation.constraints.NotBlank(message = "profilePic can not be Empty")
	public String profilePic;

}
