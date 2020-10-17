package com.springboot.cruddemo.dao;

import java.util.List;

import com.springboot.cruddemo.entity.Employee;


public interface EmployeeDao {
	
	public List<Employee> getAll();
	
	public Employee findById(int theId);
	
	public void save(Employee emp);
	
	public void deleteById(int theId);

}
