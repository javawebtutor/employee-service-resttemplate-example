package com.jwt.emp.mgmt.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.emp.mgmt.app.model.Employee;
import com.jwt.emp.mgmt.app.service.EmployeeAPIService;

@RestController
@RequestMapping("/api/v1")
public class EmployeeClientController {

	@Autowired
	private EmployeeAPIService employeeAPIService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeAPIService.getAllEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
		Employee employee = employeeAPIService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employee);
		
	}

	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeAPIService.createEmployee(employee);
	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId,
			@RequestBody Employee employeeDetails) {
		Employee employee = employeeAPIService.updateEmployee(employeeId, employeeDetails);
		return ResponseEntity.ok(employee);

	}
	
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable("id") Long employeeId){
		return employeeAPIService.deleteEmployee(employeeId);
	}
}
