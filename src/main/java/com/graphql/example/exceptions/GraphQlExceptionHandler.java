package com.graphql.example.exceptions;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;

@Component
public class GraphQlExceptionHandler {//implements GraphQLErrorHandler {

	@ExceptionHandler(GraphQLException.class)
	public ThrowableGraphQLError handle(GraphQLException e) {
		return new ThrowableGraphQLError(e);
		
	}
	
	
	
//	@Override
//	public List<GraphQLError> processErrors(List<GraphQLError> arg0) {
//		return null;
//	}

}
