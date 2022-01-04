package com.example.addressbook.dto;

import lombok.Data;

/**
 * Respond https status message and data
 * @author praja
 */
public @Data class ResponceDTO {

	private String message;
	private Object data;

	public ResponceDTO(String message, Object data) {
		this.message = message;
		this.data = data;
	}

}
