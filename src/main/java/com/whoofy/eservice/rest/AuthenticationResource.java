package com.whoofy.eservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whoofy.eservice.domain.AuthToken;
import com.whoofy.eservice.domain.LoginUser;
import com.whoofy.eservice.security.TokenProvider;
import com.whoofy.eservice.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthenticationResource {

	@Autowired
	private TokenProvider jwtTokenUtil;

	@Autowired
	private UserService userService;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginUser data) {
		try {
			String username = data.getUsername();
			String token = jwtTokenUtil.generateToken(username, userService.findByUserName(username).getRoles());
			return ResponseEntity.ok(new AuthToken(token));
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid email/password supplied");
		}
	}

}
