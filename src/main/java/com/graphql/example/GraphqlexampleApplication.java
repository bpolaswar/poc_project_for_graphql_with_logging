package com.graphql.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlexampleApplication {

	public static void main(String[] args) {
//		RuntimeWiring.newRuntimeWiring().scalar(ExtendedScalars.Json);
		SpringApplication.run(GraphqlexampleApplication.class, args);
	}

}
