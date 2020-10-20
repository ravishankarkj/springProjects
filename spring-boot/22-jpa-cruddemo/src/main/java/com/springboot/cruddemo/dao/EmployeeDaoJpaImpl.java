package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	
	EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll() {
		Query theQuery = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee employee =entityManager.find(Employee.class, theId);
		return employee;
	}

	@Override
	public void save(Employee emp) {
		Employee employee = entityManager.merge(emp);
		
		emp.setId(employee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:empid");
		theQuery.setParameter("empId", theId);
		theQuery.executeUpdate();
	}

}
