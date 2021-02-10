package com.graphql.example.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Department;
import com.graphql.example.service.DepartmentService;

import graphql.GraphQLException;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class DepartmentQueryResolver implements GraphQLQueryResolver {

	@Autowired
	private DepartmentService departmentService;

	public List<Department> deptList() {
		log.info("log info");
		log.debug("debug info");
		return departmentService.deptList();

	}

	public Optional<Department> getDepartmentById(long id) {
//		return departmentService.getDepartmentById(id);
		Optional<Department> department = departmentService.getDepartmentById(id);
		if(null != department) {
			log.info("log info");
			return department;
		}
		else		
			throw new GraphQLException("Dept not found");
	}

}
