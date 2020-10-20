package com.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
	
	EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee = currentSession.get(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee emp) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(emp);

	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Employee> query = currentSession.createQuery("delete from Employee where id=:empId");
		
		query.setParameter("empId", theId);
		
		query.executeUpdate();

	}

}
