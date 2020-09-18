package com.jwt.spring.boot.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.spring.boot.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
