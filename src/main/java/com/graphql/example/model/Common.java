package com.graphql.example.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data()
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
//@Where(clause = "active = true")
public class Common {
	@Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
	private boolean active;
}
