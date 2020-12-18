package com.whoofy.eservice.service;

import java.util.List;

import com.whoofy.eservice.domain.User;
import com.whoofy.eservice.rest.dto.UserDto;

public interface UserService {

	List<User> findAll();

	User findById(String id);

	User save(UserDto user);
	
	void delete(String id);

	User findOne(String username);

	User findByUserName (String username);

}
