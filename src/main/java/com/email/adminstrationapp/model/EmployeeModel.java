package com.email.adminstrationapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees_list")
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@Column(name = "department")
	private String department;

	@Column(name = "mailbox_capacity")
	private int mailboxCapacity;

	@Column(name = "alt_email")
	private String alternateEmail;

	@Column(name = "emp_email")
	private String employeeEmail;

	public EmployeeModel(String firstName, String lastName, String password, String department,
			String alternateEmail, String employeeEmail) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.department = department;
		this.alternateEmail = alternateEmail;
		this.employeeEmail = employeeEmail;
		this.mailboxCapacity = 50;
	}

	public EmployeeModel() {
	};

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	@Override
	public String toString() {
		return "EmployeeModel [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", department=" + department + ", mailboxCapacity=" + mailboxCapacity
				+ ", alternateEmail=" + alternateEmail + ", employeeEmail=" + employeeEmail + "]";
	}

}
