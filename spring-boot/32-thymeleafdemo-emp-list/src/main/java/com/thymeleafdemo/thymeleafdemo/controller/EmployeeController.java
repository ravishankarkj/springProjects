package com.thymeleafdemo.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thymeleafdemo.thymeleafdemo.entity.Employee;

@Controller
@RequestMapping("/")
public class EmployeeController {
	
//	List<Employee> theEmployees;
//	
//	@PostConstruct
//	public void loadData() {
//		Employee emp1 = new Employee("Jason","Hord","json@gmail.com");
//		Employee emp2 = new Employee("Henry","Ford","henry@gmail.com");
//		Employee emp3 = new Employee("Mike","Tyson","mike@gmail.com");
//		Employee emp4 = new Employee("Steve","Waugh","steve@gmail.com");
//		
//		theEmployees = new ArrayList<>();
//		theEmployees.add(emp1);
//		theEmployees.add(emp2);
//		theEmployees.add(emp3);
//		theEmployees.add(emp4);
//	}

	@GetMapping("/employees")
	public String empData(Model theModel) {
		
		Employee emp1 = new Employee("Morgan1", "Stanley", "moragan1@gmail.com");
		Employee emp2 = new Employee("Morgan2", "Stanley", "moragan2@gmail.com");
		Employee emp3 = new Employee("Morgan3", "Stanley", "moragan3@gmail.com");
		Employee emp4 = new Employee("Morgan4", "Stanley", "moragan4@gmail.com");
		
		ArrayList<Employee> list = new ArrayList<>();
		
		list.addAll(List.of(emp1,emp2,emp3,emp4));
		
		theModel.addAttribute("employees", list);
		
		return "employee";
	}
}
