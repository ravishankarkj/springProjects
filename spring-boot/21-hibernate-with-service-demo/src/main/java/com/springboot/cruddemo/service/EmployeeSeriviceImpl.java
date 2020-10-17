package com.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cruddemo.dao.EmployeeDao;
import com.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeSeriviceImpl implements EmployeeService {
	
	EmployeeDao empDao;
	
	@Autowired
	public EmployeeSeriviceImpl(EmployeeDao empDao) {
		this.empDao = empDao;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		return empDao.getAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		
		return empDao.findById(theId);
	}

	@Override
	@Transactional
	public void addEmployee(Employee theEmployee) {
		empDao.save(theEmployee);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		empDao.deleteById(theId);
	}

}
