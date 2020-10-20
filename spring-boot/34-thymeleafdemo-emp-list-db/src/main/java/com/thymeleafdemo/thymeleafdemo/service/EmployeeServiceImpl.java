package com.thymeleafdemo.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleafdemo.thymeleafdemo.entity.Employee;
import com.thymeleafdemo.thymeleafdemo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeRepository empRepo;
	
	@Autowired
	public EmployeeServiceImpl (EmployeeRepository empRepo) {
		this.empRepo = empRepo;
	}

	@Override
	public List<Employee> findAll() {
		return empRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result =  empRepo.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent())
			theEmployee = result.get();
		
		return theEmployee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		
		empRepo.save(theEmployee);

	}

	@Override
	public void deleteEmployee(int theId) {
		
		empRepo.deleteById(theId);
	}

	@Override
	public List<Employee> searchByName(String theName) {
		
		List<Employee> result = null;
		
		if (theName!=null && (theName.trim().length()>0))
			result = empRepo.findByFirstNameContainsOrLastNameContainsAllIgnoreCase(theName, theName);
		else
			result = findAll();
		
		return result;
	}

}
