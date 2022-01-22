package com.project.app.service;

import java.util.*;

import com.project.app.model.Employee;

public interface IEmployeeService {

	// get all Employee
	public List<Employee> getAllEmployees();

	// get all Employee by Id
	public Optional<Employee> getEmployeeById(Integer id);

	// add Employee
	public void addEmployee(Employee employee);

	// update Employee
	public void updateEmployee(Employee employee);

	// delete Employee
	public void deleteEmployee(Integer id);
}
