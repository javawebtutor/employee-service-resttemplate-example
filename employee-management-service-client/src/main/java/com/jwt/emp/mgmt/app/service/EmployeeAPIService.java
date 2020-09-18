package com.jwt.emp.mgmt.app.service;

import java.util.List;
import java.util.Map;

import com.jwt.emp.mgmt.app.model.Employee;

public interface EmployeeAPIService {

	public List<Employee> getAllEmployees();

	public Employee createEmployee(Employee employee);

	public Employee getEmployeeById(long employeeId);

	public Employee updateEmployee(long employeeId, Employee employeeDetails);

	public Map<String, Boolean> deleteEmployee(Long employeeId);

}
