package com.graphql.example.model;

import lombok.Data;

@Data()
public class DepartmentInput {
	private long id;
	private String name;
	private boolean status;
}
