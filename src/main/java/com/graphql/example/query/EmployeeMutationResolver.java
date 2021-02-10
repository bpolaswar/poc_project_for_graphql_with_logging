package com.graphql.example.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Employee;
import com.graphql.example.model.EmployeeInput;
import com.graphql.example.service.EmployeeService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class EmployeeMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private EmployeeService employeeService;

	public Employee createEmp(EmployeeInput employeeInput) {
		return employeeService.createEmp(employeeInput);
	}

	public String deleteEmp(Long empId) {
		return employeeService.deleteEmp(empId);
	}

	public Employee updateEmp(EmployeeInput employeeInput) {
		return employeeService.updateEmp(employeeInput);
	}
}
