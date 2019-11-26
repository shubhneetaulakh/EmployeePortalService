package com.socgen.web.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socgen.exceptions.EmployeePortalException;
import com.socgen.model.EmployeeDTO;

import java.util.List;

import org.springframework.http.MediaType;

@RequestMapping("/employee/details")
public interface EmployeeControllerInterface {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	List<EmployeeDTO> getEmployeeDetails();

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO ) throws EmployeePortalException;
}
