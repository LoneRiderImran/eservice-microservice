package com.whoofy.eservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.whoofy.eservice.domain.User;
import com.whoofy.eservice.rest.dto.UserDto;
import com.whoofy.eservice.service.UserService;
import com.whoofy.eservice.util.EServiceResponse;
import com.whoofy.eservice.util.WebUtils;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserResource {

	@Autowired
	private UserService userService;

	/**
	 * @GET /users : get all users
	 * 
	 * @return list of users
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users")
	public ResponseEntity<EServiceResponse> listUser() {
		List<User> userList = userService.findAll();
		if (userList.isEmpty()) {
			return WebUtils.failureResponse("No users found");
		}
		return WebUtils.successResponse(userList);
	}

	/**
	 * @GET /users/{id} : to get user by Id
	 * 
	 * @PathVariable User Id
	 * 
	 * @return User
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/users/{id}")
	public ResponseEntity<EServiceResponse> getOne(@PathVariable(value = "id") String id) {
		User response = userService.findById(id);
		if (ObjectUtils.isEmpty(response)) {
			return WebUtils.failureResponse("User not found");
		}
		return WebUtils.successResponse(response);
	}

	/**
	 * @POST /users/signup : to sign up a user
	 * 
	 * @Request body : UserDto
	 * 
	 * @return success message
	 */
	@PostMapping("/users/signup")
	public ResponseEntity<EServiceResponse> signup(@RequestBody UserDto user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			return WebUtils.failureResponse("Sign up failed");
		}

		return WebUtils.successResponse("Sign up successful");
	}

}
