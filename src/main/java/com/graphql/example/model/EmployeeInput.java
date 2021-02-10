package com.graphql.example.model;

import lombok.Data;

@Data()
public class EmployeeInput {
	private long eid;
	private String fname;
	private String lname;
	private String salary;
	private int deptId;
}
