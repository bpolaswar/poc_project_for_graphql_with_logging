package com.graphql.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Builder
@Data()
@Table(name = "employee")
@Where(clause = "active = true")
@NoArgsConstructor
public class Employee extends Common{
	@Column(name = "eid")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eid;
	private String fname;
	private String lname;
	private String salary;
	
	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "did")
	private Department department;
}
