package com.whoofy.eservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.whoofy.eservice.domain.Application;

@Repository
public interface ApplicationRepository extends MongoRepository<Application, String> {

}
