package com.schedular.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.schedular.backend.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

}
