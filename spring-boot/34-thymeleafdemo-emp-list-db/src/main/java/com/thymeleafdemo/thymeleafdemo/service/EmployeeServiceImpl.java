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
		// TODO Auto-generated method stub
		return empRepo.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		Optional<Employee> result =  empRepo.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent())
			theEmployee = result.get();
		
		return theEmployee;
	}

	@Override
	public void addEmployee(Employee theEmployee) {
		// TODO Auto-generated method stub
		
		empRepo.save(theEmployee);

	}

	@Override
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub
		
		empRepo.deleteById(theId);
	}

}
