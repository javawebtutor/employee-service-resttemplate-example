package com.jwt.emp.mgmt.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jwt.emp.mgmt.app.model.Employee;

@Service
public class EmployeeAPIServiceImpl implements EmployeeAPIService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		String url = "http://localhost:8080/api/v1/employees";
		ResponseEntity<List<Employee>> result = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});
		List<Employee> employees = new ArrayList<>();
		employees.addAll(result.getBody());
		return employees;

	}

	@Override
	public Employee createEmployee(Employee empRequest) {
		String url = "http://localhost:8080/api/v1/employee";
		ResponseEntity<Employee> result = restTemplate.postForEntity(url, empRequest, Employee.class);
		Employee employee = new Employee();
		employee.setFirstName(result.getBody().getFirstName());
		employee.setLastName(result.getBody().getLastName());
		employee.setEmailId(result.getBody().getEmailId());
		employee.setId(result.getBody().getId());
		return employee;

	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		String url = "http://localhost:8080/api/v1//employee/" + employeeId;
		Map<String, String> param = new HashMap<>();
		param.put("id", String.valueOf(employeeId));
		Employee employee = restTemplate.getForObject(url, Employee.class, param);
		return employee;
	}

	@Override
	public Employee updateEmployee(long employeeId, Employee employeeDetails) {
		String url = "http://localhost:8080/api/v1//employee/" + employeeId;
		Employee employee = new Employee();
		employee.setId(employeeId);
		if (employeeDetails.getFirstName() != null) {
			employee.setFirstName(employeeDetails.getFirstName());
		}

		if (employeeDetails.getLastName() != null) {
			employee.setLastName(employeeDetails.getLastName());
		}

		if (employeeDetails.getEmailId() != null) {
			employee.setEmailId(employeeDetails.getEmailId());
		}

		restTemplate.put(url, employee);

		return employee;
	}

	@Override
	public Map<String, Boolean> deleteEmployee(Long employeeId) {
		String url = "http://localhost:8080/api/v1//employee/" + employeeId;
		restTemplate.delete(url);
		Map<String, Boolean> responseMap = new HashMap<>();
		responseMap.put("deleted", true);
		
		return responseMap;
	}

}
