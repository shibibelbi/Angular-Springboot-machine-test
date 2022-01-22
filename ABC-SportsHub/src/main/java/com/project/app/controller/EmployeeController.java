package com.project.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.app.model.Employee;
import com.project.app.service.IEmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeController {

	// get instance --IOC
	@Autowired
	private IEmployeeService employeeService;

	// http Methods
	// get All Employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeService.getAllEmployees();
	}

	// get employee by id
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	// post ---insert an employee
	@PostMapping("/employees")
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);

	}

	// post --update an employee
	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);

	}

	// delete an employee by id
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);

	}

}
