package com.email.adminstrationapp.dto;

public class EmailDTO {

	private String firstName;
	private String lastName;
	private String department;
	private String alternateEmail;

	public EmailDTO(String firstName, String lastName, String department,
			String alternateEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.alternateEmail = alternateEmail;
	}

	public EmailDTO() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	@Override
	public String toString() {
		return "Email [firstName=" + firstName + ", lastName=" + lastName + ", department=" + department
				+ ", alternateEmail=" + alternateEmail + "]";
	}
}
