package com.graphql.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Where;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data()
@Entity
@SuperBuilder
@Builder
@NoArgsConstructor
//@Where(clause = "active = true")
@FilterDef(
	    name = "deptActiveFilter", 
	    parameters = @ParamDef(name = "activeDept", type = "boolean")
	)
@Filter(
	    name = "deptActiveFilter", 
	    condition = "active = :activeDept"
	)
public class Department extends Common {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	public String name;

//	@Where(clause = "active = true")
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Employee> employees;
	
//	@Column(columnDefinition = "boolean default true", nullable = false)
//	private boolean status;
	
	@Column(nullable = true)
	private long prevVersionId;

}