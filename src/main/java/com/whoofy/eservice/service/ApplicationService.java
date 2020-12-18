package com.whoofy.eservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.whoofy.eservice.rest.dto.ApplicationDto;
import com.whoofy.eservice.rest.request.ApplicationRequest;

public interface ApplicationService {

	String save(ApplicationRequest dto) throws IOException;

	List<ApplicationDto> findAll();

	void updateApplicationStatus(String id, String status);

	byte[] findById(String id);

	void saveResume(String id, MultipartFile multipart);

}
