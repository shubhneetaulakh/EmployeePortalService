package com.socgen.employee_portal;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socgen.model.EmployeeDTO;
import com.socgen.service.interfaces.EmployeeServiceInterface;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = EmployeePortal.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:Application.yml")
public class EmployeeControllerImplTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeServiceInterface empServiceInterface;

	@Test
	public void testCreateEmployee() throws JsonProcessingException, Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirstName("testEmployee");
		employeeDTO.setLastName("testEmpLastName");
		employeeDTO.setGender("test");
		employeeDTO.setDepartment("QA");
		employeeDTO.setDateofbirth("2019-11-23");

		given(empServiceInterface.createEmployee(Mockito.any())).willReturn(employeeDTO);

		ObjectMapper objMapper = new ObjectMapper();
		mvc.perform(post("/employee/details").contentType(MediaType.APPLICATION_JSON)
				.content(objMapper.writeValueAsString(employeeDTO))).andExpect(status().is(200));

		verify(empServiceInterface).createEmployee(Mockito.any());

		reset(empServiceInterface);
	}
	
	@Test
	public void testGetAllEmployee() throws Exception
	{
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setFirstName("testEmployee");
		employeeDTO.setLastName("testEmpLastName");
		employeeDTO.setGender("test");
		employeeDTO.setDepartment("QA");
		employeeDTO.setDateofbirth("2019-11-23");

		given(empServiceInterface.getEmployeeDetails()).willReturn(Arrays.asList(employeeDTO));
		
		mvc.perform(get("/employee/details").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(200));
		
		verify(empServiceInterface).getEmployeeDetails();
		
		reset(empServiceInterface);
		
	}
}
