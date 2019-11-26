package com.socgen.web.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.socgen.exceptions.EmployeePortalException;
import com.socgen.model.EmployeeDTO;
import com.socgen.service.interfaces.EmployeeServiceInterface;
import com.socgen.web.interfaces.EmployeeControllerInterface;

@RestController
@CrossOrigin
public class EmployeeControllerImpl implements EmployeeControllerInterface {

	@Autowired
	private EmployeeServiceInterface employeeService;

	public List<EmployeeDTO> getEmployeeDetails() {
		return employeeService.getEmployeeDetails();
	}

	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) throws EmployeePortalException {
		return employeeService.createEmployee(employeeDTO);
	}

}
