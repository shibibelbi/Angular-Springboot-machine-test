package com.project.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.app.model.Employee;
import com.project.app.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImp implements IEmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;

	// get list of Employee
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	// get Employee by Id
	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	// add employee by id
	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	// update an employee by Id
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	// delete an employee by id
	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);

	}

}
