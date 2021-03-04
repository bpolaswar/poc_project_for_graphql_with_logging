package com.graphql.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.example.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department getDeptByName(String name);
	
	public Department getDepartmentByPrevVersionId(Long prevVersionId);

}
