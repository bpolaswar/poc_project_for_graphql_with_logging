package com.graphql.example.model;

import javax.persistence.MappedSuperclass;

import lombok.Builder;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass
@FilterDef(name = "deptIdsFilter", parameters = @ParamDef(name = "deptIds", type = "long"))
@Filter(name = "deptIdsFilter", condition = "demo IN (:deptIds)")
//@FilterDef(
//		  name = "activeFilter", 
//		  parameters = @ParamDef(name = "active", type = "int"), 
//		  defaultCondition = "active" + "= :" + "active")
//		@Filter(name = "activeFilter")
public class Common {
    private boolean active;
    private Long demo;
}
