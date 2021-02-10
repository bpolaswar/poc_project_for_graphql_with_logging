package com.graphql.example.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Employee;
import com.graphql.example.service.EmployeeService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class EmployeeQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private EmployeeService employeeService;

	public List<Employee> allEmployees() {
		return employeeService.allEmployees();
	}

	public Optional<Employee> getEmployeeById(long id) {
		return employeeService.getEmployeeById(id);

	}

}
