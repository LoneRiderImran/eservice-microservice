package com.whoofy.eservice.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.whoofy.eservice.domain.Application;
import com.whoofy.eservice.domain.User;
import com.whoofy.eservice.enums.ApplicationStatus;
import com.whoofy.eservice.exeception.UserNotFoundException;
import com.whoofy.eservice.repository.ApplicationRepository;
import com.whoofy.eservice.rest.dto.ApplicationDto;
import com.whoofy.eservice.rest.request.ApplicationRequest;
import com.whoofy.eservice.security.SecurityUtils;
import com.whoofy.eservice.service.ApplicationService;
import com.whoofy.eservice.service.UserService;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicationRepository applicationRepository;

	@Override
	public String save(ApplicationRequest dto) throws IOException {

		Application application = dtoToApplicationMapping(dto);

		Application savedApplication = applicationRepository.save(application);

		return savedApplication.getId();
		
	}

	@Override
	public List<ApplicationDto> findAll() {

		List<Application> application = applicationRepository.findAll();

		List<ApplicationDto> dtos = applicationToDtoMapping(application);

		return dtos;

	}

	@Override
	public void updateApplicationStatus(String id, String status) {

		Optional<Application> application = applicationRepository.findById(id);

		if (application.isPresent()) {

			application.get().setStatus(ApplicationStatus.valueOf(status));

			applicationRepository.save(application.get());

		} else {

			throw new UserNotFoundException("User not found");

		}

	}

	private Application dtoToApplicationMapping(ApplicationRequest dto) {

		Application application = new Application();

		application.setAddress(dto.getAddress());
		application.setDob(dto.getDob());
		application.setExpectedSalary(dto.getExpectedSalary());
		application.setFirstName(dto.getFirstName());
		application.setHasCompletdUg(dto.getHasCompletdUg());
		application.setHasCompletedPg(dto.getHasCompletedPg());
		application.setIsExperienced(dto.getIsExperienced());
		application.setLastName(dto.getLastName());
		application.setMobile(dto.getMobile());
		application.setPositionType(dto.getPositionType());
		application.setPreviousSalary(dto.getPreviousSalary());
		application.setYearsOfExperience(dto.getYearsOfExperience());
		application.setStatus(ApplicationStatus.Submitted);
		User user = userService.findByUserName(SecurityUtils.getCurrentUser());
		application.setUserId(user.getId());

		return application;

	}

	private List<ApplicationDto> applicationToDtoMapping(List<Application> applicationList) {

		List<ApplicationDto> dtoList = new ArrayList<>();

		for (Application app : applicationList) {

			ApplicationDto applicationDto = new ApplicationDto();

			applicationDto.setId(app.getId());
			applicationDto.setAddress(app.getAddress());
			applicationDto.setDob(app.getDob());
			applicationDto.setExpectedSalary(app.getExpectedSalary());
			applicationDto.setFirstName(app.getFirstName());
			applicationDto.setHasCompletdUg(app.getHasCompletdUg());
			applicationDto.setHasCompletedPg(app.getHasCompletedPg());
			applicationDto.setIsExperienced(app.getIsExperienced());
			applicationDto.setLastName(app.getLastName());
			applicationDto.setMobile(app.getMobile());
			applicationDto.setPositionType(app.getPositionType());
			applicationDto.setPreviousSalary(app.getPreviousSalary());
			applicationDto.setYearsOfExperience(app.getYearsOfExperience());

			dtoList.add(applicationDto);

		}

		return dtoList;

	}

	@Override
	public byte[] findById(String id) {

		Optional<Application> app = applicationRepository.findById(id);

		if (app.isPresent()) {
			return app.get().getResume();
		}

		return null;
	}

	@Override
	public void saveResume(String id, MultipartFile file) {
		// TODO Auto-generated method stub

		Optional<Application> application = applicationRepository.findById(id);

		if (application.isPresent()) {

			byte[] byteArr = null;

			try {
				byteArr = file.getBytes();
			} catch (Exception e) {
				
			}

			application.get().setResume(byteArr);

			applicationRepository.save(application.get());

		}
	}

}
