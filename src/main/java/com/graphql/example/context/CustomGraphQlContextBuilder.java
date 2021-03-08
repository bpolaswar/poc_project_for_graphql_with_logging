package com.graphql.example.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;

import org.springframework.stereotype.Component;

import com.graphql.example.dataloader.DataLoaderRegistryFactory;

import graphql.kickstart.execution.context.GraphQLContext;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.servlet.context.GraphQLServletContextBuilder;

@Component
public class CustomGraphQlContextBuilder implements GraphQLServletContextBuilder {
	 private final DataLoaderRegistryFactory dataLoaderRegistryFactory ;

	    public CustomGraphQlContextBuilder(DataLoaderRegistryFactory dataLoaderRegistryFactory) {
	        this.dataLoaderRegistryFactory = dataLoaderRegistryFactory;
	    }

	
	@Override
	public GraphQLContext build() {
		// TODO Auto-generated method stub
		throw new IllegalStateException("unsupported");
	}

	@Override
	public GraphQLContext build(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		// TODO Auto-generated method stub
		 var context = DefaultGraphQLServletContext.createServletContext()
		 .with(httpServletRequest)
		 .with(httpServletResponse)
		 .with(dataLoaderRegistryFactory.create())
		 .build();
		 return new CustomGraphqlContext(context);

	}

	@Override
	public GraphQLContext build(Session arg0, HandshakeRequest arg1) {
		// TODO Auto-generated method stub
		throw new IllegalStateException("unsupported");
	}

	
	
}
