package com.schedular.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schedular.backend.model.Employee;
import com.schedular.backend.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee>getAllEmployees(){
		List<Employee>employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	public void updateEmployee(int id, Employee employee) throws Exception {
		Employee updateEmployee = getEmployeeById(id).orElseThrow(() -> new Exception("Id:" + id + " not found"));
		updateEmployee.setfirstname(employee.getfirstname());
		updateEmployee.setlastname(employee.getlastname());
		updateEmployee.setPhone(employee.getPhone());
		employeeRepository.save(updateEmployee);
	
	}
	
	public void deleteEmployee(int id) throws Exception {
		employeeRepository.deleteById(id);
	}
}
