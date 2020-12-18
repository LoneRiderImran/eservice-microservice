package com.whoofy.eservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.whoofy.eservice.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	public User findByUsername(String username);

}
