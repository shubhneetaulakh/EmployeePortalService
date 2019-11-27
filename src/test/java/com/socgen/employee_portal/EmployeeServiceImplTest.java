package com.socgen.employee_portal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.socgen.entity.EmployeeEntity;
import com.socgen.model.EmployeeDTO;
import com.socgen.repository.EmployeeRepository;
import com.socgen.service.impl.EmployeeServiceImpl;
import com.socgen.service.interfaces.EmployeeServiceInterface;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	
	@TestConfiguration
	  static class EmployeeServiceImplTestContextConfiguration {
	    @Bean
	    public EmployeeServiceInterface employeeService() {
	      return new EmployeeServiceImpl();
	    }
	  }

	  @Autowired
	  private EmployeeServiceInterface empServiceInterface;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	public void testCreateEmployee() {
		
        EmployeeEntity employeeEntity = new EmployeeEntity();
		
		employeeEntity.setFirstName("testEmployee");
		employeeEntity.setLastName("testEmpLastName");
		employeeEntity.setGender("test");
		employeeEntity.setDepartment("QA");
		employeeEntity.setDateofbirth("2019-11-23");
		
		Mockito.when(employeeRepository.save(employeeEntity)).thenReturn(employeeEntity);
	}

	@Test
	public void testGetEmployeeList() {
		List<EmployeeDTO> employeeList = empServiceInterface.getEmployeeDetails();
		assertThat(employeeList).isNotNull();
	}

}
