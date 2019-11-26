package com.socgen.service.interfaces;

import java.util.List;
import com.socgen.model.EmployeeDTO;

public interface EmployeeServiceInterface {

	List<EmployeeDTO> getEmployeeDetails();

	EmployeeDTO createEmployee(EmployeeDTO employeeData);
}
