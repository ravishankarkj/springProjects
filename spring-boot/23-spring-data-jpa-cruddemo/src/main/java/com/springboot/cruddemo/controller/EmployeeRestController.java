package com.springboot.cruddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	EmployeeService empService;

	@Autowired
	public EmployeeRestController(EmployeeService empService) {
		this.empService = empService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return empService.findAll();
	}

	@GetMapping("/employees/{empId}")
	public Employee findById(@PathVariable int empId) {
		Employee employee = empService.findById(empId);

		if (employee == null)
			throw new RuntimeException("Employee not found " + empId);

		return employee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);

		empService.addEmployee(employee);

		return employee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

		empService.addEmployee(employee);

		return employee;
	}

	@DeleteMapping("/employees/{theId}")
	public String deleteEmployee(@PathVariable int theId) {
		Employee employee = empService.findById(theId);

		if (employee == null)
			throw new RuntimeException("Employee not found " + theId);
		
		empService.deleteEmployee(theId);

		return "Deleted employee with id "+theId;
	}

}
