package com.santt4na.primestore_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
	private String email;
	private String password;
	
	public LoginRequestDTO() {
	}
}
