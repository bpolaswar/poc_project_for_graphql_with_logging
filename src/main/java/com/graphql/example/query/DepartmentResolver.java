package com.graphql.example.query;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Department;
import com.graphql.example.model.Employee;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.scalars.ExtendedScalars;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.RuntimeWiring;
@Component
public class DepartmentResolver implements GraphQLResolver<Department> {
	
	public CompletableFuture<List<Employee>> getEmployees(Department dept, DataFetchingEnvironment dfe){
		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.Json);
        DataLoader<Long,List<Employee>> dataLoader = dfe.getDataLoader(DataLoaderRegistryFactory.EMPLOYEE_DATA_LOADER);
        return dataLoader.load(dept.getId());
    }


}
