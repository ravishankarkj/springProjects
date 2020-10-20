package com.thymeleafdemo.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thymeleafdemo.thymeleafdemo.entity.Employee;
import com.thymeleafdemo.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeDbController {
	
	EmployeeService empService;
	
	@Autowired
	public EmployeeDbController (EmployeeService empService) {
		this.empService = empService;
	}
	
	@GetMapping("/list")
	public String findAll(Model theModel) {
		
		List<Employee> employees = empService.findAll();
		
		theModel.addAttribute("employees", employees);
		
		return "employee";
	}
	
	@GetMapping("/showFormForUpdate")
	public String findById(Model theModel, @RequestParam("employeeId") int theId) {
		
		Employee theEmployee = empService.findById(theId);
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel, Employee theEmployee) {
		theModel.addAttribute("employee", theEmployee);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String saveForm(@ModelAttribute("employee") Employee theEmployee) {
		
		if (theEmployee!=null) {
			this.empService.addEmployee(theEmployee);
		}
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId) {
		
		empService.deleteEmployee(theId);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/search")
	public String searchEmployee(@RequestParam("employeeName") String theName, Model theModel) {
		
		List<Employee> employees = empService.searchByName(theName);
		
		theModel.addAttribute("employees", employees);
		
		return "employee";
	}
	
}




