package com.email.adminstrationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.email.adminstrationapp.model.EmployeeModel;

@Repository
public interface EmailRepository extends JpaRepository<EmployeeModel, String> {
	EmployeeModel findByEmployeeEmail(String employeeEmail);
}
