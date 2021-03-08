package com.graphql.example.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Department;
import com.graphql.example.model.DepartmentInput;
import com.graphql.example.service.DepartmentService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class DepartmentMutationResolver implements GraphQLMutationResolver {

	@Autowired
	private DepartmentService departmentService;

	public Department createDepartment(DepartmentInput departmentInput) {
		return departmentService.createDepartment(departmentInput);
	}

	public String deleteDept(long deptId) {
		return departmentService.deleteDept(deptId);
	}

	public Department updateDept(DepartmentInput departmentInput) {
		return departmentService.updateDept(departmentInput);
	}
}
