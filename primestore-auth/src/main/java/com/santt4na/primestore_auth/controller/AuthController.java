package com.santt4na.primestore_auth.controller;

import com.santt4na.primestore_auth.dto.LoginRequestDTO;
import com.santt4na.primestore_auth.dto.RegisterRequestDTO;
import com.santt4na.primestore_auth.dto.ResponseDTO;
import com.santt4na.primestore_auth.entity.User;
import com.santt4na.primestore_auth.repository.UserRepository;
import com.santt4na.primestore_auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body){
		User user = this.repository.findByEmail(body.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
		if(passwordEncoder.matches(body.getPassword(), user.getPassword())) {
			String token = this.tokenService.generateToken(user);
			return ResponseEntity.ok(new ResponseDTO(user.getName(), token));
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body){
		Optional<User> user = this.repository.findByEmail(body.getEmail());
		
		if(user.isEmpty()) {
			User newUser = new User();
			newUser.setPassword(passwordEncoder.encode(body.getPassword()));
			newUser.setEmail(body.getEmail());
			newUser.setName(body.getName());
			this.repository.save(newUser);
			
			String token = this.tokenService.generateToken(newUser);
			return ResponseEntity.ok(new ResponseDTO(newUser.getName(), token));
		}
		
		return ResponseEntity.badRequest().build();
	}
}