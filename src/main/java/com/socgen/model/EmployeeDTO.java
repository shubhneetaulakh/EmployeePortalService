package com.socgen.model;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {

	@NotEmpty
	private String firstName;
	private String lastName;
	private String gender;
	private String department;
	private String dateofbirth;
}
