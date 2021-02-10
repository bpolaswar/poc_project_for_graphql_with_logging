package com.graphql.example.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphql.example.model.Department;
import com.graphql.example.model.Employee;
@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	    List<Employee> findByDepartment_IdIn(Set<Long> departmentIds);


}
