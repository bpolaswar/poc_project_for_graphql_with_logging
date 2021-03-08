package com.graphql.example.context;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.dataloader.DataLoaderRegistry;

import graphql.kickstart.servlet.context.GraphQLServletContext;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public class CustomGraphqlContext implements GraphQLServletContext {

	private final GraphQLServletContext context;
	
	@Override
	public Optional<DataLoaderRegistry> getDataLoaderRegistry() {
		// TODO Auto-generated method stub
		return context.getDataLoaderRegistry();
	}

	@Override
	public Optional<Subject> getSubject() {
		// TODO Auto-generated method stub
		return context.getSubject();
	}

	@Override
	public List<Part> getFileParts() {
		// TODO Auto-generated method stub
		return context.getFileParts();
	}

	@Override
	public HttpServletRequest getHttpServletRequest() {
		// TODO Auto-generated method stub
		return context.getHttpServletRequest();
	}

	@Override
	public HttpServletResponse getHttpServletResponse() {
		// TODO Auto-generated method stub
		return context.getHttpServletResponse();
	}

	@Override
	public Map<String, List<Part>> getParts() {
		// TODO Auto-generated method stub
		return context.getParts();
	}

}
