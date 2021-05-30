package com.schedular.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schedular.backend.model.Employee;
import com.schedular.backend.service.EmployeeService;


@RestController
@RequestMapping(value="/employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public List<Employee>getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmployee(@PathVariable("id") String id) {
		Optional<Employee> employee = null;
		try {
			employee = employeeService.getEmployeeById(Integer.valueOf(id));
			return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/newemployee")
	public ResponseEntity<String> addNewEmployee(@RequestBody Employee employee) {
		try {
			employeeService.addEmployee(employee);
			return new ResponseEntity<String>("Employee added", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<String>updateEmployee(@RequestBody Employee employee, @PathVariable("id") String id){
		try {
			employeeService.updateEmployee(Integer.valueOf(id), employee);
			return new ResponseEntity<String>("Employee updated", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmployee(@PathVariable("id") String id){
		try {
			employeeService.deleteEmployee(Integer.valueOf(id));
			return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
