package com.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cruddemo.dao.EmployeeRepository;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeSeriviceImpl implements EmployeeService {
	
	EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeSeriviceImpl(EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = empRepo.findById(theId);
		
		Employee employee= null;
		
		if (result.isPresent()) {
			employee = result.get();
		}
		
		return employee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		empRepo.save(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {
		empRepo.deleteById(theId);
	}

}
