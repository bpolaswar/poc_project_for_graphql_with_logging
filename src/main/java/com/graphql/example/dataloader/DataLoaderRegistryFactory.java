package com.graphql.example.dataloader;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.dataloader.DataLoader;
import org.dataloader.DataLoaderRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.example.model.Employee;
import com.graphql.example.service.EmployeeService;

import graphql.scalars.ExtendedScalars;
import graphql.schema.idl.RuntimeWiring;

@Component
public class DataLoaderRegistryFactory {
    public static final String EMPLOYEE_DATA_LOADER = "EMPLOYEE_DATA_LOADER";

    public static final Executor balanceThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    @Autowired
    private EmployeeService empService;


    public DataLoaderRegistry create() {
        RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.Json);
        var registry = new DataLoaderRegistry();
        registry.register(EMPLOYEE_DATA_LOADER, createEmpDataLoader());
        return registry;
    }


    private DataLoader<Long, List<Employee>> createEmpDataLoader() {

        return DataLoader.newMappedDataLoader((Set<Long> departmentIds) ->
                CompletableFuture.supplyAsync(() ->
                                empService.getEmployeesByDepartmentIds(departmentIds),
                        balanceThreadPool));
    }

}
