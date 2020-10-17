package com.thymeleafdemo.thymeleafdemo.service;

import java.util.List;

import com.thymeleafdemo.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void addEmployee(Employee theEmployee);
	
	public void deleteEmployee(int theId);
}
