package com.resource;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.jboss.resteasy.plugins.providers.html.View;

import com.db.Student;
import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
@Path("/")
public class HelloResources {
	@Inject
	Hello h;
	@GET
	public View hello() throws IOException{
		List<Student> stdList=h.displayStudent();
		return new View("index.jsp",stdList,"stdList");
	}

}
