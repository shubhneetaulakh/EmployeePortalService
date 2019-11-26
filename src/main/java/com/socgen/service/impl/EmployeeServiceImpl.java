package com.socgen.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socgen.entity.EmployeeEntity;
import com.socgen.model.EmployeeDTO;
import com.socgen.repository.EmployeeRepository;
import com.socgen.service.interfaces.EmployeeServiceInterface;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	public List<EmployeeDTO> getEmployeeDetails() {
		List<EmployeeDTO> employeesList = new ArrayList<>();
		List<EmployeeEntity> employeeEntity = employeeRepository.findAllByOrderByFirstNameAsc();

		employeeEntity.forEach(employee -> {
			EmployeeDTO employeeDto = new EmployeeDTO();
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());
			employeeDto.setGender(employee.getGender());
			employeeDto.setDepartment(employee.getDepartment());
			employeeDto.setDateofbirth(employee.getDateofbirth());
			employeesList.add(employeeDto);

		});

		return employeesList;

	}

	public EmployeeDTO createEmployee(EmployeeDTO employeeData) {
		
		//Create the new employee in the entity 
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(employeeData.getFirstName());
		employeeEntity.setLastName(employeeData.getLastName());
		employeeEntity.setGender(employeeData.getGender());
		employeeEntity.setDepartment(employeeData.getDepartment());
		employeeEntity.setDateofbirth(employeeData.getDateofbirth());
		
		// save the entity in the database
		EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
		
		//get the saved entity and mapped it to DTO for sending response
		EmployeeDTO savedEmployeeDTO = new EmployeeDTO();
		savedEmployeeDTO.setFirstName(savedEmployee.getFirstName());
		savedEmployeeDTO.setLastName(savedEmployee.getLastName());
		savedEmployeeDTO.setGender(savedEmployee.getGender());
		savedEmployeeDTO.setDepartment(savedEmployee.getDepartment());
		savedEmployeeDTO.setDateofbirth(savedEmployee.getDateofbirth());
//		
//		Optional<EmployeeEntity> newUser = employeeRepository.findById(savedEmployee.getId());
//	    if (newUser.isPresent()) {
//	    	savedEmployeeDTO.setFirstName(newUser.get().getFirstName());
//			savedEmployeeDTO.setLastName(newUser.get().getLastName());
//			savedEmployeeDTO.setGender(newUser.get().getGender());
//			savedEmployeeDTO.setDepartment(newUser.get().getDepartment());
//			savedEmployeeDTO.setDateofbirth(newUser.get().getDateofbirth());
//	    }
	    
		return savedEmployeeDTO;
		
	}

}
