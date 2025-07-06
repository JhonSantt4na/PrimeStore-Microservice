package com.santt4na.primestore_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
	private String name;
	private String token;
	
	public ResponseDTO(String name, String token) {
		this.name = name;
		this.token = token;
	}
	
	public ResponseDTO() {
	}
}