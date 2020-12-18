package com.whoofy.eservice.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.whoofy.eservice.rest.dto.ApplicationDto;
import com.whoofy.eservice.rest.request.ApplicationRequest;
import com.whoofy.eservice.service.ApplicationService;
import com.whoofy.eservice.util.EServiceResponse;
import com.whoofy.eservice.util.WebUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ApplicationResource {

	@Autowired
	private ApplicationService applicationService;

	/*
	 * @POST /application : to post application
	 * 
	 * @Request Body ApplicationDto
	 * 
	 * @RequestParam MultipartFile
	 * 
	 * @Response ResponseEntity with success message
	 * 
	 */
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/application")
	public ResponseEntity<EServiceResponse> postApplication(@RequestBody ApplicationRequest dto) throws IOException {
		String applicationId = null;
		try {
			applicationId = applicationService.save(dto);
		} catch (Exception e) {
			return WebUtils.failureResponse("Something went wrong while posting application");
		}

		return WebUtils.successResponse("Application with ID : " + applicationId + " ,Submitted successfully");

	}

	/**
	 * @POST /application/resume : to upload resume
	 * @param id
	 * @param multipart
	 * @return
	 * @throws IOException
	 */
	@PreAuthorize("hasRole('USER')")
	@PostMapping("/application/resume")
	public ResponseEntity<EServiceResponse> uploadResume(@RequestParam("id") String id,
			@RequestParam("file") MultipartFile multipart) throws IOException {

		if (ObjectUtils.isEmpty(multipart)) {
			return WebUtils.failureResponse("Please upload resume");
		}

		if (multipart.getOriginalFilename().contains(".pdf")) {

			applicationService.saveResume(id, multipart);

			return WebUtils.successResponse("Resume submitted successfully");

		}

		return WebUtils.failureResponse("Please upload PDF file");

	}

	/*
	 * @GET /application : To get all applications
	 * 
	 * @Response ResponseEntity with list of applications
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/application")
	public ResponseEntity<EServiceResponse> getAllApplications() {

		List<ApplicationDto> response = applicationService.findAll();

		if (response.isEmpty()) {
			WebUtils.failureResponse("No application found");
		}

		return WebUtils.successResponse(response);
	}

	/**
	 * @PUT /application : update status of application
	 * @param id
	 * @param status
	 * @return success or failure message if user not found
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/application")
	public ResponseEntity<EServiceResponse> updateApplicationStatus(
			@RequestParam(name = "id", required = true) String id,
			@RequestParam(name = "statsu", required = true) String status) {

		try {
			applicationService.updateApplicationStatus(id, status);
		} catch (Exception e) {
			return WebUtils.failureResponse(e.getMessage());
		}

		return WebUtils.successResponse("Application Status Updated Successfully");

	}

	/**
	 * @GET /application/resume/{id} : to download resume
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/application/resume/{id}")
	public void downloadResume(@PathVariable String id, HttpServletResponse response) throws IOException {

		byte[] rawFile = applicationService.findById(id);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=resume_" + id + ".pdf");
		OutputStream out = response.getOutputStream();
		out.write(rawFile);

	}

}
