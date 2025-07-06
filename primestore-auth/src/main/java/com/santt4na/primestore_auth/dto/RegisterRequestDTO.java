package com.santt4na.primestore_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {
	private String name;
	private String email;
	private String password;
	
	public RegisterRequestDTO() {
	}
}
