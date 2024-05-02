package com.email.adminstrationapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.adminstrationapp.dto.EmailDTO;
import com.email.adminstrationapp.model.EmployeeModel;
import com.email.adminstrationapp.repository.EmailRepository;
import com.email.adminstrationapp.utility.RandomPasswordGenerator;

@RestController
public class EmailAdministrationController {

	@Autowired
	private EmailRepository emailRepo;

	private String companySuffix = "xyzcompany.com";

	private String firstName;
	private String lastName;
	private String randomPassword;
	private String department;
	private String altEmail;

	@PostMapping("/email/create")
	public ResponseEntity<String> CreateNewEmail(@RequestBody EmployeeModel emailBody) {
		try {

			// parsing the data from RequestBody
			firstName = emailBody.getFirstName();
			lastName = emailBody.getLastName();
			department = emailBody.getDepartment();
			altEmail = emailBody.getAlternateEmail();

			// Generate random password for employee
			RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
			randomPassword = randomPasswordGenerator.generateRandomPassword(10);

			// Generate email for employee
			String employeeEmail = firstName.toLowerCase() + "." + lastName.toString() + "@" + department.toString()
					+ companySuffix;
			
			// creating new Employee
			EmployeeModel newEmployee = new EmployeeModel(firstName, lastName, randomPassword, department,
					altEmail, employeeEmail);
			emailRepo.save(newEmployee);
			
			return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error occured" + e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getEmployee")
	public ResponseEntity<EmailDTO> getEmployeeDetails(@RequestBody EmployeeModel emailBody) {
		try {
			// get employee details by email
			EmployeeModel email = emailRepo.findByEmployeeEmail(emailBody.getEmployeeEmail());

			// adding data to response dto
			EmailDTO employeeDto = new EmailDTO();
			employeeDto.setFirstName(email.getFirstName());
			employeeDto.setLastName(email.getLastName());
			employeeDto.setDepartment(email.getDepartment());
			employeeDto.setAlternateEmail(email.getAlternateEmail());

			return new ResponseEntity<>(employeeDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<EmailDTO>(null);
		}
	}

}
